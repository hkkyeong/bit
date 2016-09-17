package winder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.MemberService;
import winder.vo.MemberVO;

@Controller
public class ManageController {
	
	@Autowired
	private MemberService memberService;
	
	//manage member
	@RequestMapping(value="/manage")
	public String manage(Model model){
		model.addAttribute("membercount", memberService.countMember()-1);
		model.addAttribute("todayjoin", memberService.todayJoin());
		model.addAttribute("member", memberService.selectAllMember());
		return "manage/manage_member";
	}
	
	//member out
	@RequestMapping(value="/memberout")
	public String memberOut(MemberVO vo, HttpServletRequest request){
		return "";
	}
	
	//manage report
	@RequestMapping(value="/report")
	public String report(Model model){
		return "manage/manage_report";
	}
	
	//manage notice
	@RequestMapping(value="/notice")
	public String notice(Model model){
		return "manage/manage_notice";
	}
}
