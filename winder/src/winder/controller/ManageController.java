package winder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.MemberService;

@Controller
public class ManageController {
	
	@Autowired
	private MemberService memberService;
	
	//manage member
	@RequestMapping(value="/manage")
	public String manage(Model model){
		model.addAttribute("membercount", memberService.countMember());
		model.addAttribute("todayjoin", memberService.todayJoin());
		model.addAttribute("member", memberService.selectAllMember());
		return "manage/manage_member";
	}
	
	//manage report
	@RequestMapping(value="/report")
	public String report(Model model){
		return "manage/manage_report";
	}
	
	//manage notice
	@RequestMapping(value="/notice")
	public String notice(Model model){
		//
		return "manage/manage_notice";
	}
}
