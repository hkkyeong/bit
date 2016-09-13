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
	
	//manage home
	@RequestMapping(value="/manage")
	public String manage(Model model){
		model.addAttribute("member", memberService.selectAllMember());
		model.addAttribute("membercount", memberService.countMember());
		return "manage/manage_member";
	}
}
