package winder.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.MembersService;
import winder.service.ProjectService;
import winder.service.TodoListService;
import winder.service.TodoService;
import winder.vo.MembersVO;
import winder.vo.ProjectVO;
import winder.vo.TodoJoinVO;
import winder.vo.TodoVO;

@Controller
public class ProgressController {
	@Autowired
	private TodoListService todolistService;
	@Autowired
	private TodoService todoService;
	@Autowired
	private MembersService membersService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "wholeprogress")
	public String wholeProgress(Model model, HttpServletRequest request, HttpSession session) throws Exception {
		String id=(String)session.getAttribute("id");
		// 프로젝트 진행률
		int temp = 0;
		//List<TodoJoinVO> plist = todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		List<TodoJoinVO> plist = todolistService.selectTdDate(Integer.parseInt(request.getParameter("pno")));
		List<TodoJoinVO> pastlist = new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < plist.size(); i++) {
			Date today=sdf.parse(sdf.format(new Date()));
			Date cdate=sdf.parse(plist.get(i).getTldate());
			long ll=cdate.getTime();
			long l2=today.getTime();
			long ld=(ll-l2)/(24*60*60*1000); //tldate-today 일수 계산
			if(ld<0){
				pastlist.add(plist.get(i));
			}
			//진행률
			if (plist.get(i).getState().equals("2")) {
				temp++;
			}
		}
		double per = (double) temp / (double) plist.size() * 100.0;
		model.addAttribute("per", (int) per);
		model.addAttribute("done", temp);
		model.addAttribute("size", plist.size());
		model.addAttribute("past", pastlist);

		// todo bar
		HashMap<String, Integer> hm = new LinkedHashMap<>();
		//HashMap<String, Integer> hm2 = new HashMap<>();
		List<TodoVO> tdlist = todoService.listTodo(Integer.parseInt(request.getParameter("pno")));
		int temp2 = 0;
		int state = 0;
		double dou = 0;
		for (int i = 0; i < tdlist.size(); i++) {
			temp2 = 0;
			state = 0;
			for (int j = 0; j < plist.size(); j++) {
				// todo의 content tilte, todolist의 content 같을 경우 hashmap에
				// content를 key로 저장
				// content 같을 때 state=2일 경우 진행률 계산 위해 +1
				if (tdlist.get(i).getContent().equals(plist.get(j).getTitle())) {
					temp2++;
					if (plist.get(j).getState().equals("2")) {
						state++;
					}
				}
			}
			dou = (double) state / (double) temp2 * 100.0;
			hm.put(tdlist.get(i).getContent(), (int) dou);
		}
		model.addAttribute("tdlist", tdlist);
		model.addAttribute("ab", hm);
		model.addAttribute("plist", plist);
		
		//leader인지 아닌지
		ProjectVO pvo=new ProjectVO();
		pvo=projectService.selectProject(Integer.parseInt(request.getParameter("pno")));
		MembersVO vo=new MembersVO();
		vo.setId(id);
		vo.setTno(pvo.getTno());
		String leaderchk=membersService.selectMembersPosition(vo).getPosition();
		if(leaderchk.equals("leader")){
			model.addAttribute("leaderchk", leaderchk);
		}else{
			model.addAttribute("leaderchk", "x");
		}
		
		return "project/wholeprogress";
	}

}