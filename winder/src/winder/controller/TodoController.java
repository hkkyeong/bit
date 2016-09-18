package winder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import winder.service.MembersService;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.service.TodoListService;
import winder.service.TodoService;
import winder.vo.TodoJoinVO;
import winder.vo.TodoListVO;
import winder.vo.TodoVO;


@Controller
public class TodoController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private TodoListService todolistService;
	@Autowired
	private TodoService todoService;
	@Autowired
	private MembersService membersService;
	
	//메뉴 프로젝트 목록 선택
	@RequestMapping(value="todo")
	public String todo(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		
		//프로젝트 진행률
		int temp=0;
		List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		for(int i=0; i<plist.size(); i++){
			if(plist.get(i).getState().equals("2")){
				temp++;				
			}
		}
		double per=(double)temp/(double)plist.size()*100.0;
		model.addAttribute("per", (int)per);
		model.addAttribute("done", temp);
		model.addAttribute("size", plist.size());
		
		//todo bar
		HashMap<String, Integer> hm=new HashMap<>();
		List<TodoVO> tdlist=todoService.listTodo(Integer.parseInt(request.getParameter("pno")));
		int temp2=0;
		int state=0;
		double dou=0;
		for(int i=0; i<tdlist.size(); i++){
			temp2=0;
			state=0;
			for(int j=0; j<plist.size(); j++){
				//todo의 content tilte, todolist의 content 같을 경우 hashmap에 content를 key로 저장
				//content 같을 때 state=2일 경우 진행률 계산 위해 +1
				if(tdlist.get(i).getContent().equals(plist.get(j).getTitle())){
					temp2++;
					if(plist.get(j).getState().equals("2")){
						state++;
					}
				}
			}
			dou=(double)state/(double)temp2*100.0;
			hm.put(tdlist.get(i).getContent(), (int)dou);
		}
		List<HashMap<String, Integer>> tdmap=new ArrayList<>();
		tdmap.add(hm);
		model.addAttribute("ab", hm);
		model.addAttribute("tdlist", tdmap);
		model.addAttribute("todo", plist);
		String pno=(String)request.getParameter("pno");
		model.addAttribute("pno", pno);
		model.addAttribute("plist", plist);
		return "project/progress";
	}
	
	//to do list 관리 페이지
	@RequestMapping(value="todomanagepage")
	public String todomanagepage(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		List<TodoJoinVO> tllist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		model.addAttribute("tlist", todoService.listTodo(Integer.parseInt(request.getParameter("pno"))));
		model.addAttribute("tllist", tllist);
		model.addAttribute("mlist", membersService.teamMember(request.getParameter("pno")));
		model.addAttribute("pno", request.getParameter("pno"));
		return "project/todomanage";
	}
	
	@RequestMapping(value="todoinsert")
	public String todoinsert(Model model, TodoVO vo, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		try {
			int count=todoService.insertTodo(vo);
			if(count==1){
				return url;
			}else{
				return url;
			}
		} catch (Exception e) {
			return url;
		}
	}
	
	@RequestMapping(value="todolistinsert")
	public String todolistinsert(Model model, TodoListVO vo, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		try {
			int count=todolistService.insertTodoList(vo);
			if(count==1){
				return url;
			}else{
				return url;
			}
		} catch (Exception e) {
			return url;
		}
	}
	
	//todo 삭제
	@RequestMapping(value="tododelete")
	public String tododelete(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("pno", request.getParameter("pno"));
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		try {
			int count=todoService.deleteTodo(Integer.parseInt(request.getParameter("tdno")));
			if(count==1){
				return url;
			}else{
				return url;
			}
		} catch (Exception e) {
			return url;
		}
	}
	
	//todolist 삭제
	@RequestMapping(value="todolistdelete")
	public String todolistdelete(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("pno", request.getParameter("pno"));
		try {
			int count=todolistService.deleteTodoList(Integer.parseInt(request.getParameter("tlno")));
			if(count==1){
				return "redirect:/todomanagepage";
			}else{
				return "redirect:/todomanagepage";
			}
		} catch (Exception e) {
			return "redirect:/todomanagepage";
		}
	}
	
	//todo 수정 form
	@RequestMapping(value="todoupdateform")
	public String todoupdateform(Model model, HttpSession session, HttpServletRequest request, RedirectAttributes reatt){
		if(request.getParameter("update").equals("update")){
			//수정 버튼
			try {
				//tdno로 검색한 todo 리턴 받음
				reatt.addFlashAttribute("todoselect", todoService.selectTodo(Integer.parseInt(request.getParameter("tdno"))));
				reatt.addAttribute("update", "todoupdate");
			} catch (Exception e) {
				System.out.println("todoselect 실패");
				System.out.println(e);
			}
		}else{
			//삭제
			try {
				int count=todoService.deleteTodo(Integer.parseInt(request.getParameter("tdno")));
				if(count==1){
				}else{
				}
			} catch (Exception e) {
				System.out.println("todo 삭제 실패");
				System.out.println(e);
			}
		}
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		return url;
	}
	
	//todolist 수정 form
	@RequestMapping(value="todolistupdateform")
	public String todolistupdateform(Model model, HttpSession session, HttpServletRequest request, RedirectAttributes reatt){
		if(request.getParameter("update").equals("update")){
			//수정 버튼
			try {
				//tlno로 검색한 todolist 리턴 받음
				reatt.addFlashAttribute("todolistselect", todolistService.selectSubtitle(Integer.parseInt(request.getParameter("tlno"))));
				reatt.addAttribute("update", "todolistupdate");
			} catch (Exception e) {
				System.out.println("todolistselect 실패");
				System.out.println(e);
			}
		}else{
			//삭제 버튼
			try {
				int count=todolistService.deleteTodoList(Integer.parseInt(request.getParameter("tlno")));
				if(count==1){
				}else{
				}
			} catch (Exception e) {
				System.out.println("todolist 삭제 실패");
			}
		}
		
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		return url;
	}
	
	//todo 수정
	@RequestMapping(value="todoupdate")
	public String todoupdate(TodoVO vo, Model model, HttpServletRequest request){
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		try {
			int count=todoService.updateTodo(vo);
			if(count==1){
				return url;
			}else{
				return url;
			}
		} catch (Exception e) {
			return url;
		}
	}
	
	//todolist 수정
	@RequestMapping(value="todolistupdate")
	public String todolistupdate(TodoListVO vo, Model model, HttpServletRequest request){
		String pno=(String)request.getParameter("pno");
		String url="redirect:/todomanagepage?pno="+pno;
		try {
			int count=todolistService.updateTodoList(vo);
			if(count==1){
				return url;
			}else{
				return url;
			}
		} catch (Exception e) {
			return url;
		}
	}
	
	//드래그 앤 드롭 state = done 
	@RequestMapping(value="statedone")
	public void statedone(HttpServletRequest request, HttpServletResponse response){
		int temp=0;
		try {
			int count=todolistService.statedone(request.getParameter("tlno"));
			if(count==1){
				List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
				for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getState().equals("2")){
						temp++;				
					}
				}
				double per=(double)temp/(double)plist.size()*100.0;
				JSONObject jobj=new JSONObject();
				jobj.put("size", plist.size());
				jobj.put("done", temp);
				jobj.put("per", (int)per);
				PrintWriter pw=response.getWriter();
				pw.print(jobj);
				pw.flush();
				pw.close();
			}else{
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//드래그 앤 드롭 state = todo
	@RequestMapping(value="statetodo")
	public void statetodo(HttpServletRequest request, HttpServletResponse response){
		int temp=0;
		//state 수정
		try {
			int count=todolistService.statetodo(request.getParameter("tlno"));
			if(count==1){
				List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
				for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getState().equals("2")){
						temp++;				
					}
				}
				double per=(double)temp/(double)plist.size()*100.0;
				JSONObject jobj=new JSONObject();
				jobj.put("size", plist.size());
				jobj.put("done", temp);
				jobj.put("per", (int)per);
				PrintWriter pw=response.getWriter();
				pw.print(jobj);
				pw.flush();
				pw.close();
				
				
				
			}else{
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@RequestMapping(value="bar")
	public void bar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//bar
		List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		List<TodoVO> tdlist=todoService.listTodo(Integer.parseInt(request.getParameter("pno")));
		int temp2=0;
		int state=0;
		double dou=0;
		String cont;
		JSONObject jobj=new JSONObject();
		for(int i=0; i<tdlist.size(); i++){
			temp2=0;
			state=0;
			for(int j=0; j<plist.size(); j++){
				//todo의 content tilte, todolist의 content 같을 경우 hashmap에 content를 key로 저장
				//content 같을 때 state=2일 경우 진행률 계산 위해 +1
				if(tdlist.get(i).getContent().equals(plist.get(j).getTitle())){
					temp2++;
					if(plist.get(j).getState().equals("2")){
						state++;
					}
				}
			}
			dou=(double)state/(double)temp2*100.0;
			cont=tdlist.get(i).getContent();
			jobj.put(URLEncoder.encode(cont, "UTF-8"), (int)dou);
		}
		PrintWriter prw;
		try {
			prw = response.getWriter();
			prw.print(jobj.toString());
			prw.flush();
			prw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
