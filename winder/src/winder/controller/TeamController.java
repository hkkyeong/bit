package winder.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.TeamVO;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	@Autowired
	private ProjectService projectService;
	
	//메뉴 팀 선택
	@RequestMapping(value="team")
	public String team(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("projectlist", projectService.selectProjectList(request.getParameter("tno")));
		return "project/projectList";
	}
	
	//팀 리스트
	@RequestMapping(value="teamList")
	public String teamList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teamList",teamService.selectTeamList(id));
		return "team/teamList";
	}
	
	//팀 생성 form
		@RequestMapping(value="teamCreateform")
		public String teamForm(Model model, HttpSession session){
			return "team/teamCreateform";
		}

		//팀 생성
		@RequestMapping(value="teamCreate")
		public String teamCreate(TeamVO vo,HttpServletRequest request, HttpSession sesstion){
			/*String name= request.getParameter("name");
			String timg =request.getParameter("timg");

			vo.setName(name);
			vo.setTimg(timg);*/

			try {
				int count=teamService.insertTeam(vo);
				if(count==1){
					return "redirect:/team";
				}else{
					return "redirect:/index";
				}
			} catch (Exception e) {
				return "redirect:/index";
			}
		}

		//팀 삭제
		@RequestMapping(value="teamDelete")
		public String teamDelete(HttpServletRequest request){
			HttpSession session = request.getSession();
			String id =(String) session.getAttribute("id");
			int tno =Integer.parseInt(request.getParameter("tno"));
			int result = teamService.deleteTeam(tno);
			if(result==1){
				return "redirect:/teamList";

			}else{
				return "redirect:/index";
			}

		}
		
	/*	@RequestMapping(value="teamimg")
		public String teamimg(TeamVO vo, HttpServletRequest request, Model model){
			String path=request.getRealPath("/upload");
			String uppath=path+"\\"+vo.getTimg().getOriginalFilename();
			File f= new File(uppath);
			try {
				vo.getTimg().transferTo(f);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			vo.setUpfile(vo.getTimg().getOriginalFilename());
			teamService.insertTeam(vo);
			return "index";
		}
	*/

}
