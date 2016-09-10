package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import winder.service.MemberService;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.MemberVO;

@Controller
public class LoginController {

	//autossss
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;

	// home
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		if ("loginok".equals(session.getAttribute("loginchk"))) {
			//헤더 정보
			model.addAttribute("teammenu", teamService.selectTeamList(id));
			model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		} else {

		}

		return "index";
	}

	// login form
	@RequestMapping(value = "/login")
	public String login() {
		return "loginform";
	}

	// login check
	@RequestMapping(value = "/loginchk")
	public String loginchk(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO user = memberService.selectMember(id);
		// id 있는지 확인
		if (user != null && user.getId() != null) {
			// id와 패스워드 맞는지 확인
			if (memberService.chkMember(user) == 1) {
				if(id.equals("manager")){
					session.setAttribute("id", id);
					session.setAttribute("loginchk", "loginok");
					return "redirect:/home";
				}else{
					session.setAttribute("id", id);
					session.setAttribute("loginchk", "loginok");
					return "redirect:/home";
				}
			} else {
				return "loginform";
			}
		} else {
			return "loginform";

		}
	}

	// logout
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginchk");
		session.removeAttribute("id");
		return "redirect:/home";
	}

}
