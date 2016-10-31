package winder.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import winder.dao.FilterDAOImpl;
import winder.service.MemberService;
import winder.service.NoteService;
import winder.service.UploadFileService;
import winder.vo.MemberVO;
import winder.vo.NoteVO;
import winder.vo.OutMemberVO;
import winder.vo.UploadfileVO;

@Controller
public class ManageController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private UploadFileService uploadFileService; 
	@Autowired
	private FilterDAOImpl filterService;
	@Autowired 
	private NoteService noteService;

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
		List<UploadfileVO> filelist=uploadFileService.listFile();
		List<String> filter=filterService.listFilster();
		//필터링 된 리스트 따로 뽑기
		List<UploadfileVO> ulist=new ArrayList<>();
		for(int i=0; i<filelist.size(); i++){
			for(int j=0; j<filter.size(); j++){
				if(filelist.get(i).getOriginalname().matches(".*"+filter.get(j)+".*") || filelist.get(i).getUtitle().matches(".*"+filter.get(j)+".*")){
					System.out.println("");
					ulist.add(filelist.get(i));
					//	filelist.remove(i);
				}
			}
		}

		for(int i=0; i<filelist.size(); i++){
			for(int j=0; j<ulist.size(); j++){
				if(filelist.get(i)==ulist.get(j)){
					filelist.remove(i);
				}
			}
		}

		model.addAttribute("filter", filter);
		model.addAttribute("filelist", filelist);
		model.addAttribute("filterfile", ulist);
		return "manage/manage_check";
	}

	//manage check
	@RequestMapping(value="/filter")
	public String filter(HttpServletRequest request){
		try {
			filterService.insertFilter(request.getParameter("fword"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/check";
	}

	//manage notice
	@RequestMapping(value="/notice")
	public String notice(Model model){		
		return "manage/manage_notice";
	}

	//insertNotice
	@RequestMapping(value="/insertNotice")
	public String insertNotice( HttpServletRequest request){		

		String ntitle =request.getParameter("ntitle");
		String sid =request.getParameter("sid");
		String nC =request.getParameter("ncontent");
		
		List<MemberVO> mL =memberService.selectAllMember();

		for(int i =0; i<mL.size();i++){
			NoteVO note =new NoteVO();

			MemberVO m =mL.get(i);
			String mId =m.getId();
			System.out.println(mId);

			note.setNtitle(ntitle);
			note.setNcontent(nC);
			note.setSid(sid);
			note.setRid(mId);
			
			noteService.insertNote(note);
			

		}

		return "redirect:/notice";

	}



}
