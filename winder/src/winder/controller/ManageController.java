package winder.controller;

import javax.servlet.http.HttpServletRequest;

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
		model.addAttribute("membercount", memberService.countMember()-1);
		model.addAttribute("todayjoin", memberService.todayJoin());
		model.addAttribute("member", memberService.selectAllMember());
		return "manage/manage_member";
	}
	
	//member out
	@RequestMapping(value="/memberout")
	public String memberOut(HttpServletRequest request){
		/*MemberVO mvo=new MemberVO();
		OutMemberVO ovo=new OutMemberVO();
		mvo=memberService.selectMember(request.getParameter("id"));
		//강제 탈퇴시킬 멤버 outmember 테이블에 insert
		ovo.setId(mvo.getId());
		ovo.setJoindate(mvo.getJoindate());
		ovo.setName(mvo.getName());
		ovo.setReason(request.getParameter("reason"));
		try {
			int count=memberService.outMember(ovo);
			if(count==1){
				int c=memberService.deleteMember(mvo.getId());
				if(c==1){
					return "redirect:/manage";
				}else{
					return "redirect:/manage";
				}
				return "redirect:/manage";
			}else{
				return "redirect:/manage";
			}
		} catch (Exception e) {
			return "redirect:/manage";
		}*/
		return "d";
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
