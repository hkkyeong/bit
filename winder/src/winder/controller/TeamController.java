package winder.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.TeamVO;

@Controller
public class TeamController {

	@Autowired 
	private TeamService teamService;
	@Autowired
	private ProjectService projectService;
	DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();

	//메뉴 팀 선택
	@RequestMapping(value="team")
	public String team(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");
		String pno=(String)request.getParameter("pno");
		model.addAttribute("teammenu", teamService.selectTeamList(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));
		model.addAttribute("projectlist", projectService.selectProjectList(request.getParameter("tno")));
		request.setAttribute("pno",pno);
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
	@RequestMapping(value="teamCreate",method = { RequestMethod.POST, RequestMethod.GET } )
	public String teamCreate(TeamVO vo,HttpServletRequest request) throws IOException{

		vo =new TeamVO();
		String path ="C:\\비트\\workspace\\0901\\0830\\WebContent\\upload\\";
		int size = 1024*1024*5;
		String enc ="utf-8";

		MultipartRequest multi =new MultipartRequest(request,path,size,enc,dfrp);
		/*String timg =multi.getParameter("timg");*/
		String name =multi.getParameter("name");
		String timg =multi.getFilesystemName("timg");
		String code ="";

		vo.setName(name);
		vo.setTimg(timg);
		vo.setCode(code);

		try {

			int count=teamService.insertTeam(vo);
			if(count==1){
				return "redirect:/teamList";
			}else{
				return "redirect:/index";
			}
		} catch (Exception e) {
			return "redirect:/signupForm";
		}
	}

	//팀 삭제
	@RequestMapping(value="teamDelete")
	public String teamDelete(HttpServletRequest request){
		int tno =Integer.parseInt(request.getParameter("tno"));
		int result = teamService.deleteTeam(tno);
		if(result==1){
			return "redirect:/teamList";
		}else{
			return "redirect:/index";
		}
	}
	//팀 수정 form
	@RequestMapping(value="teamUpdateform")
	public String teamUpdateForm(HttpServletRequest request){
		int tno =Integer.parseInt(request.getParameter("tno"));
		request.setAttribute("tno", tno);   
		return "team/teamUpdateform";
	}


	//팀 업데이트
	@RequestMapping(value="teamUpdate")
	public String teamUpdate(HttpServletRequest request) throws IOException{
		String path ="C:\\비트\\workspace\\0901\\0830\\WebContent\\upload\\";
		int size = 1024*1024*5;
		String enc ="utf-8";
		MultipartRequest multi =new MultipartRequest(request,path,size,enc,dfrp);
		int tno =Integer.parseInt(request.getParameter("tno"));	
		String name =multi.getParameter("name");
		String timg =multi.getFilesystemName("timg");

		TeamVO team =teamService.selectTeam(tno);

		team.setName(name);
		team.setTimg(timg);

		int result = teamService.updateTeam(team);
		if(result==1){
			return "redirect:/teamList";
		}else{
			return "redirect:/index";
		}
	}
}
