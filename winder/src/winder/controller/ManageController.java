package winder.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.MemberService;
import winder.service.ScrapServiceImpl;
import winder.service.UploadFileService;
import winder.vo.MemberVO;
import winder.vo.OutMemberVO;

@Controller
public class ManageController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private UploadFileService uploadFileService; 
	@Autowired 
	private ScrapServiceImpl scrapService;
	
	//manage member
	@RequestMapping(value="/manage")
	public String manage(Model model){
		model.addAttribute("membercount", memberService.countMember()-1);
		model.addAttribute("todayjoin", memberService.todayJoin());
		model.addAttribute("member", memberService.selectAllMember());
		model.addAttribute("outmember", memberService.outMemberList());
		return "manage/manage_member";
	}
	
	//member out
	@RequestMapping(value="/memberout")
	public String memberOut(HttpServletRequest request){
		MemberVO mvo=new MemberVO();
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
				//outmember insert 성공 후 해당 멤버 삭제
				int c=memberService.deleteMember(mvo.getId());
				if(c==1){
					return "redirect:/manage";
				}else{
					return "redirect:/manage";
				}
			}else{
				return "redirect:/manage";
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			return "redirect:/manage";
		}

	}
	
	//manage check
	@RequestMapping(value="/check")
	public String report(Model model){
		model.addAttribute("filelist", uploadFileService.listFile());
		
		return "manage/manage_check";
	}
	
	//manage notice
	@RequestMapping(value="/notice")
	public String notice(Model model){
		return "manage/manage_notice";
	}
}
