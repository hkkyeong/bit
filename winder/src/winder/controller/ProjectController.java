package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import winder.service.MembersService;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.MembersVO;
import winder.vo.ProjectVO;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private MembersService membersService;
	
	//프로젝트 관리 form
	@RequestMapping(value="projectmanage")
	public String projectmanage(Model model, HttpServletRequest request){
		System.out.println("pno: "+request.getParameter("pno"));
		try {
			ProjectVO vo=projectService.selectProject(Integer.parseInt(request.getParameter("pno")));
			model.addAttribute("p", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/projectmanage";
	}
		
	//프로젝트 생성 form
	@RequestMapping(value="projectform")
	public String projectForm(Model model, HttpSession session,HttpServletRequest req){
		String id=(String)session.getAttribute("id");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("tno",req.getParameter("tno"));
		return "project/projectCreate";
	}
	
	//프로젝트 생성
	@RequestMapping(value="projectcreate")
	public String project(ProjectVO vo, HttpSession session){
		try {
			int count=projectService.insertProject(vo);
			if(count==1){
				return "redirect:/home";
			}else{
				return "redirect:/home";
			}
		} catch (Exception e) {
			return "redirect:/home";
		}
	}
	//프로젝트 목록
	@RequestMapping(value="projectlist")
	public String projectlist(Model model, HttpSession session, HttpServletRequest request){
		String id = (String) session.getAttribute("id");
		if(request.getParameter("tno")==null){
		}else{
			model.addAttribute("plist", projectService.selectProjectList(request.getParameter("tno")));
			//추가 -- 근데 tno 왜 넘기지???
			model.addAttribute("tno",request.getParameter("tno"));
		}
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		return"project/projectselect";
	}
	//프로젝트 메인
	@RequestMapping(value="projectmain")
	public String projectmain(Model model, HttpSession session, HttpServletRequest request){
		String id = (String) session.getAttribute("id");
		String pno=(String)request.getParameter("pno");
		model.addAttribute("pno", pno);
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("tno",projectService.selectProjectTno(Integer.parseInt(pno)));
		return"project/projectmain";
	}
	
	// 프로젝트 관리
		@RequestMapping(value="projectmanagement")
		public String projectupdate(Model model,HttpSession session,HttpServletRequest req,ProjectVO vo){
			
			System.out.println("(controller)project management tno value check :"+req.getParameter("tno")); 
			model.addAttribute("pno", (String)req.getParameter("pno"));
			
			int pno=Integer.parseInt(req.getParameter("pno"));
			try{
				vo = projectService.selectProject(pno);
				model.addAttribute("pvo", vo);
				return "project/projectupdate";
			}catch(Exception e){
				System.out.println("project select error.!");
				return "redirect:/home";
			}
			//System.out.println(vo);
			
		}
		
		
		//project 관리 form 요청.
		@RequestMapping(value="projectmanagementform")
		public String projectmanagementtest(Model model,HttpSession session,HttpServletRequest req,HttpServletResponse res,ProjectVO vo,MembersVO members){
			
			members.setTno(Integer.parseInt(req.getParameter("tno")));
			members.setId((String)session.getAttribute("id"));
			
			try{
				members=membersService.selectMembersPosition(members);
				//System.out.println("(controller)project management members get vo value : "+members);
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("members's table access fail.");
				return "redirect:/home";
			}
			
			if(members.getPosition().equals("leader")){
				
				System.out.println("현재 접속된 id="+session.getAttribute("id")+"의 position="+members.getPosition()+",접근 권한 o");
				model.addAttribute("pno", (String)req.getParameter("pno"));
				int pno=Integer.parseInt(req.getParameter("pno"));
				
				try{
					
					vo=projectService.selectProject(pno);
					model.addAttribute("pvo", vo);
					return "project/projectmanagement";
					
				}catch(Exception e){
					e.printStackTrace();
					return "project/projectmanagement";
				}
				
			}else{	// position 값이 member라면,
				
				    System.out.println("현재 접속된 id="+session.getAttribute("id")+"의 position="+members.getPosition()+",접근 권한 없음.");
				    return "redirect:/home";		
			}
			
		}
		//project update form 요청.
		@RequestMapping(value="projectupdateform")
		public String projectupdateform(Model model,HttpServletRequest req,ProjectVO vo){
			//String pno = req.getParameter("pno");
			int pno=Integer.parseInt(req.getParameter("pno"));
			try{
				vo = projectService.selectProject(pno);
				model.addAttribute("pvo", vo);
				return "project/projectupdate";
			}catch(Exception e){
				System.out.println("project select error.!");
				return "redirect:/home";
			}
		}
		//project 삭제.
		@RequestMapping(value="projectdelete")
		public String projectdelete(Model model,HttpServletRequest req,ProjectVO vo){
			int pno=Integer.parseInt(req.getParameter("pno"));
			try{
				int count=projectService.deleteProject(pno);
				if(count>=1){
					System.out.println("delete count : "+count);
					return "redirect:/home";
				}
				else{
					System.out.println("delete count : 0");
					return "redirect:/project/projectselect";
				}
			}catch(Exception e){
				System.out.println("delete fail");
				return "redirect:/home";
			}
		}
		
		@RequestMapping(value="projectupdate",method={RequestMethod.GET,RequestMethod.POST})
		public String updateproject(HttpServletRequest req,ProjectVO vo){
			
			String pno=(String)req.getParameter("pno");
			String exdate=(String)req.getParameter("pexdate");
			//System.out.println("exdate : "+exdate);
			/*SimpleDateFormat format= new SimpleDateFormat("yyyy-mm-dd");
			Date date=format.parse(exdate);
			System.out.println("format : "+date);*/
			vo.setPno(Integer.parseInt(pno));
			vo.setExdate(exdate);
			vo.setName((String)req.getParameter("pname"));
			vo.setContent((String)req.getParameter("pcontent"));

			try{
				int count=projectService.updateProject(vo);
				if(count>=1){
					System.out.println("update count : "+count);
					return "project/projectmain";
				}
				else{
					System.out.println("update fail");
					return "redirect:/project/projectupdate";
				}
			}catch(Exception e){
				System.out.println(pno+"'s project update fail");
				return "redirect:/project/projectupdate";
			}
			
		}
}
