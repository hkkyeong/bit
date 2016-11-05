package winder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.MemberService;
import winder.service.MembersService;
import winder.service.NoteService;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.MemberVO;
import winder.vo.MembersVO;
import winder.vo.MypageTeamInfoVO;
import winder.vo.NoteVO;
import winder.vo.TeamVO;

@Controller
public class MypageController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private MembersService membersService;
	@Autowired 
	private NoteService noteService;

	// mypage form 
	@RequestMapping(value="/mypage")
	public String mypage(Model model,HttpSession session,MemberVO vo){
		if(session.getAttribute("loginchk").equals("loginno")){
			return "guest";
		}else{
			String id = (String)session.getAttribute("id");
			model.addAttribute("teammenu", teamService.selectTeamList(id));
			model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
			vo=memberService.selectMember(id);
			model.addAttribute("member", vo);

			return "mypage/mypagemain";
		}
		
	}
	@RequestMapping(value="/profilemain")
	public String profilemain(HttpSession session,Model model,MemberVO vo){

		String id = (String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		vo=memberService.selectMember(id);
		model.addAttribute("member", vo);
		return "mypage/profilemain";
	}

	// 개인 정보 수정 폼 요청. 
	@RequestMapping(value="/profileupdateform")
	public String profileupdateform(HttpServletRequest req,HttpSession session,Model model,MemberVO vo){
		String id = (String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		vo=memberService.selectMember((String)session.getAttribute("id"));
		model.addAttribute("member", vo);

		return "mypage/profileupdateform";
	}

	// 개인정보 수정.
	@RequestMapping(value="/profileupdate")
	public String profileupdate(MemberVO member,HttpSession session){

		try{
			member.setId((String)session.getAttribute("id"));
			int count=memberService.updateMember(member);
			if(count==1){
				return "redirect:/home";
			}else{
				return "redirect:/home";
			}

		}catch(Exception e){
			e.printStackTrace();
			return "redirect:/home";
		}


	}

	// 비밀번호 변경 폼 요청.
	@RequestMapping(value="/passwordupdateform")
	public String passwordupdateform(){
		return "mypage/passwordupdateform";
	}

	// 비밀번호 변경.
	@RequestMapping(value="/passwordupdate")
	public String passwordupdate(HttpSession session,HttpServletRequest req,MemberVO member){
		String id=(String)session.getAttribute("id");
		String beforepassword=(String)req.getParameter("beforepassword");
		String updatepassword=(String)req.getParameter("updatepassword");
		String updatepassword2=(String)req.getParameter("updatepassword2");

		member=memberService.selectMember(id);
		//System.out.println("member password : "+member.getPassword());
		//System.out.println("input password : "+beforepassword);
		if(member.getPassword().equals(beforepassword)){
			// 이전 비밀번호가 일치한다면, 새로운 비밀번호를 세팅.

			if(updatepassword.equals(updatepassword2)){
				member.setPassword(updatepassword);
				try{
					int count=memberService.updatePassword(member);
					return "redirect:/mypage";
				}catch(Exception e){
					e.printStackTrace();
					return "redirect:/home";
				}
			}else{
				return "redirect:/passwordupdate";
			}

		}else{	// 이전 비밀번호 불일치,
			//System.out.println("Old password does not match.");
			return "redirect:/home";
		}

	}
	@RequestMapping(value="teaminfo")
	public String teaminfo(HttpSession session,Model model,MemberVO vo) throws Exception{
		if(session.getAttribute("loginchk").equals("loginno")){
			return "guest";
		}else{
			String id = (String)session.getAttribute("id");
			model.addAttribute("teammenu", teamService.selectTeamList(id));
			model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
			vo=memberService.selectMember(id);
			model.addAttribute("id",id);

			TeamVO team = new TeamVO();
			MypageTeamInfoVO teaminfovo = null;
			List<MypageTeamInfoVO> teaminfo = new ArrayList<>();

			List<TeamVO> teamlist =  teamService.selectTeamList(id);
			List<MembersVO> memberslist = new ArrayList<>();
			List<MembersVO> memberslist2 = null;
			List<MembersVO> memberslist3 =new ArrayList<>();

			if(teamlist.size() ==0){
				
				return "redirect:/mypage";
				
			}else{
				List<List<MembersVO>> m=new ArrayList<>();
				List<List<MembersVO>> ms=new ArrayList<>();

				for(int i=0; i<teamlist.size(); i++){
					List<MembersVO> li=membersService.selectAllMembersTno(teamlist.get(i).getTno());
					m.add(i, li);
				}
				model.addAttribute("abc", m);

				//List<Map<String,Object>> map =null;

				for (TeamVO teamvo : teamlist) {	//teamlist의 팀들을 하나씩 꺼내서 각각의 tno를 통해 tname을 구함.

					teaminfovo = new MypageTeamInfoVO();
					memberslist2 = new ArrayList<>();
					team = teamService.selectTeamName(teamvo.getTno());
					teaminfovo.setName(teamvo.getName());
					teaminfovo.setTno(teamvo.getTno());
					teaminfovo.setTimg(teamvo.getTimg());
					memberslist = membersService.selectAllMembersTno(teamvo.getTno());


					for (MembersVO membersvo : memberslist) {
						if(membersvo.getPosition().equals("leader")){
							teaminfovo.setLeader(membersvo.getId());					
							List<MembersVO> lmvo=new ArrayList<>();
							lmvo=membersService.selectTeamMember(teamvo.getTno());
							for(int i=0; i<lmvo.size(); i++){

								memberslist3.add(lmvo.get(i));
							}
						}
						else{
							memberslist2.add(membersvo);

						}
					}

					teaminfo.add(teaminfovo);

				}
				
			}

			model.addAttribute("teaminfo", teaminfo);
			model.addAttribute("memberslist",memberslist3);


			return "mypage/teaminfolist";
		}
		
	}

	@RequestMapping(value="teamout")
	public String teamout(HttpServletRequest req,HttpSession session,MembersVO members){

		try{
			members.setTno(Integer.parseInt(req.getParameter("tno")));
			members.setId((String)req.getParameter("id"));

			int count = membersService.deleteMembersTeamOut(members);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/teaminfo";
	}


	@RequestMapping(value="teamdelete")
	public String teamdelete(HttpServletRequest req,HttpSession session,Model model){

		try{
			int count = teamService.deleteTeam(Integer.parseInt(req.getParameter("tno")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/teaminfo";
	}

	@RequestMapping(value="inviteMember")
	public String inviteMember(HttpServletRequest req,HttpSession session,Model model){

		String sid =(String) session.getAttribute("id");
		String id=req.getParameter("id");
		int tno = Integer.parseInt(req.getParameter("tno"));
		String tname =req.getParameter("tname");

		String con =sid+"님이 "+tname+"팀으로 초대하였습니다.";

		NoteVO note =new NoteVO();
		note.setNtitle("초대 메시지가 도착하였습니다");
		note.setNcontent(con);
		note.setRid(id); 
		note.setSid(sid);

		int count = noteService.insertNote(note);

		MembersVO members = new MembersVO();
		members.setId(id);
		members.setTno(tno);
		members.setPosition("member");
		members.setState("1");   


		int result = membersService.inviteM(members);

		if(result ==1){			
			return "redirect:/teaminfo";
		}
 
		return "redirect:/teaminfo";

	}

	@RequestMapping(value="acceptMember")
	public String acceptMember(HttpServletRequest req,HttpSession session,Model model){

		String id =(String) session.getAttribute("id"); 
		String sid =req.getParameter("sid");

		MembersVO mvo=membersService.selectMembersTnoS(id);
		
		mvo.setState("2");
		
		int s = membersService.updateMembers(mvo);

		if(s ==1){
		}

		return "redirect:/mypage";
	}

}
