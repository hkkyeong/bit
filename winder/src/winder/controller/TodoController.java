package winder.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
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
	public String todo(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		String id=(String)session.getAttribute("id");
		
		//프로젝트 진행률
		int temp=0;
		List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		//id 별로 todolist 뽑기 위해 새 리스트 선언
		List<TodoJoinVO> plistid = new ArrayList<>();
		List<TodoJoinVO> ddaylist = new ArrayList<>();
		List<TodoJoinVO> pastlist = new ArrayList<>();
		//list index 구분 위한 변수
		int aa=0; 
		int bb=0;
		int cc=0;
		
		//날짜 계산
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0; i<plist.size(); i++){
			if(plist.get(i).getId().equals(id)){ //todolist 중 세션 아이디의 list만 새 리스트인 plistid에 저장
				plistid.add(aa, plist.get(i));
				aa++;
			}
		}	
		model.addAttribute("todo", plistid);
		
		for(int i=0; i<plistid.size(); i++){
			Date cdate=sdf.parse(plistid.get(i).getTldate()); //todolist의 날짜
			Date today=sdf.parse(sdf.format(new Date())); //오늘 날짜
			long ll=cdate.getTime();
			long l2=today.getTime();
			long ld=(ll-l2)/(24*60*60*1000); //tldate-today 일수 계산
			if(ld<=7){ // 기한 7일 이하로 남거나 지난 리스트
				if(ld<0){ //기한 지남
					pastlist.add(plistid.get(i));
				}else{ //7일 이하의 기한 남음
					ddaylist.add(plistid.get(i));
				}
			}else{ //기한 많이 남은 리스트
				//System.out.println("날짜: "+plist.get(i).getTldate());
			}
			
			//진행률 계산
			if(plistid.get(i).getState().equals("2")){
				temp++;				
			}
		}
		double per=(double)temp/(double)plistid.size()*100.0;
		model.addAttribute("per", (int)per);
		model.addAttribute("done", temp);
		model.addAttribute("size", plistid.size());
		
		model.addAttribute("past", pastlist);
		model.addAttribute("dday", ddaylist);
				
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
		
		
		//model.addAttribute("todo", plist);
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
	public void statedone(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String id=(String)session.getAttribute("id");
		int temp=0;
		try {
			int count=todolistService.statedone(request.getParameter("tlno"));
			if(count==1){
				List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
				List<TodoJoinVO> plistid = new ArrayList<>();
				int aa=0;
				for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getId().equals(id)){
						plistid.add(aa, plist.get(i));
						aa++;
					}
				}
				for(int i=0; i<plistid.size(); i++){
					if(plistid.get(i).getState().equals("2")){
						temp++;				
					}
				}
/*				for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getState().equals("2")){
						temp++;				
					}
				}*/
				double per=(double)temp/(double)plistid.size()*100.0;
				JSONObject jobj=new JSONObject();
				jobj.put("size", plistid.size());
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
	public void statetodo(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String id=(String)session.getAttribute("id");
		int temp=0;
		//state 수정
		try {
			int count=todolistService.statetodo(request.getParameter("tlno"));
			if(count==1){
				List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
				List<TodoJoinVO> plistid = new ArrayList<>();
				int aa=0;
				for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getId().equals(id)){
						plistid.add(aa, plist.get(i));
						aa++;
					}
				}
				for(int i=0; i<plistid.size(); i++){
					if(plistid.get(i).getState().equals("2")){
						temp++;				
					}
				}
				/*for(int i=0; i<plist.size(); i++){
					if(plist.get(i).getState().equals("2")){
						temp++;				
					}
				}*/
				double per=(double)temp/(double)plistid.size()*100.0;
				JSONObject jobj=new JSONObject();
				jobj.put("size", plistid.size());
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
	
	@RequestMapping(value="pastlist")
	public void pastlist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id=(String)session.getAttribute("id");
		JSONArray jarr=new JSONArray();
		String cont;
		List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		List<TodoJoinVO> plistid = new ArrayList<>();
		List<TodoJoinVO> ddaylist = new ArrayList<>();
		List<TodoJoinVO> pastlist = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int aa=0; 
		int bb=0;
		int cc=0;

		for(int i=0; i<plist.size(); i++){
			if(plist.get(i).getId().equals(id)){ //todolist 중 세션 아이디의 list만 새 리스트인 plistid에 저장
				plistid.add(aa, plist.get(i));
				aa++;
			}
		}	
		
		for(int i=0; i<plistid.size(); i++){
			JSONObject jobj=new JSONObject();
			Date cdate=sdf.parse(plistid.get(i).getTldate()); //todolist의 날짜
			Date today=sdf.parse(sdf.format(new Date())); //오늘 날짜
			long ll=cdate.getTime();
			long l2=today.getTime();
			long ld=(ll-l2)/(24*60*60*1000); //tldate-today 일수 계산
			if(ld<=7){ // 기한 7일 이하로 남거나 지난 리스트
				if(ld<0){ //기한 지남
					jobj.put("state", URLEncoder.encode(plistid.get(i).getState(), "UTF-8"));
					jobj.put("title", URLEncoder.encode(plistid.get(i).getTitle(), "UTF-8"));
					jobj.put("content", URLEncoder.encode(plistid.get(i).getContent(), "UTF-8"));
					jobj.put("tldate", URLEncoder.encode(plistid.get(i).getTldate(), "UTF-8"));
					//pastlist.add(bb, plistid.get(i));
					jarr.add(jobj);

				}else{ //7일 이하의 기한 남음
					ddaylist.add(cc, plistid.get(i));
				}
			}else{ //기한 많이 남은 리스트
				//System.out.println("날짜: "+plist.get(i).getTldate());
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("pastlist", jarr);
		PrintWriter prw;
		try {
			prw = response.getWriter();
			prw.print(obj.toString());
			prw.flush();
			prw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="ddaylist")
	public void ddaylist(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception{
		String id=(String)session.getAttribute("id");
		JSONArray jarr=new JSONArray();
		String cont;
		List<TodoJoinVO> plist=todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		List<TodoJoinVO> plistid = new ArrayList<>();
		List<TodoJoinVO> ddaylist = new ArrayList<>();
		List<TodoJoinVO> pastlist = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		int aa=0; 
		int bb=0;
		int cc=0;

		for(int i=0; i<plist.size(); i++){
			if(plist.get(i).getId().equals(id)){ //todolist 중 세션 아이디의 list만 새 리스트인 plistid에 저장
				plistid.add(aa, plist.get(i));
				aa++;
			}
		}	
		
		for(int i=0; i<plistid.size(); i++){
			JSONObject jobj=new JSONObject();
			Date cdate=sdf.parse(plistid.get(i).getTldate()); //todolist의 날짜
			Date today=sdf.parse(sdf.format(new Date())); //오늘 날짜
			long ll=cdate.getTime();
			long l2=today.getTime();
			long ld=(ll-l2)/(24*60*60*1000); //tldate-today 일수 계산
			if(ld<=7){ // 기한 7일 이하로 남거나 지난 리스트
				if(ld<0){ //기한 지남
				}else{ //7일 이하의 기한 남음
					jobj.put("state", URLEncoder.encode(plistid.get(i).getState(), "UTF-8"));
					jobj.put("title", URLEncoder.encode(plistid.get(i).getTitle(), "UTF-8"));
					jobj.put("content", URLEncoder.encode(plistid.get(i).getContent(), "UTF-8"));
					jobj.put("tldate", URLEncoder.encode(plistid.get(i).getTldate(), "UTF-8"));
					//pastlist.add(bb, plistid.get(i));
					jarr.add(jobj);
				}
			}else{ //기한 많이 남은 리스트
			}
		}
		JSONObject obj=new JSONObject();
		obj.put("ddaylist", jarr);
		PrintWriter prw;
		try {
			prw = response.getWriter();
			prw.print(obj.toString());
			prw.flush();
			prw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
