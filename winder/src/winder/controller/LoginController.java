package winder.controller;

import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import winder.service.MemberService;
import winder.service.ProjectService;
import winder.service.TeamService;
import winder.vo.MemberVO;

@Controller
public class LoginController {

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
		user.setPassword(password);
		// id 있는지 확인
		if (user != null && user.getId() != null) {
			// id와 패스워드 맞는지 확인
			if (memberService.chkMember(user) == 1) {
				if(id.equals("manager")){
					session.setAttribute("id", id);
					session.setAttribute("loginchk", "loginok");
					return "redirect:/manage";
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
	
	/*@RequestMapping(value="imageCreate.ajax")
    public ModelAndView createImage (HttpServletRequest request) throws Exception{
        
        String binaryData = request.getParameter("imgSrc");
        FileOutputStream stream = null;
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");        
        try{
            System.out.println("binary file   "  + binaryData);
            if(binaryData == null || binaryData=="") {
                throw new Exception();    
            }
            
         
            binaryData = binaryData.replaceAll("data:image/png;base64,", "");
            byte[] file = Base64.decode(binaryData);
            //byte[] file = Base64.decodeBase64(binaryData);
            System.out.println("file  :::::::: " + file + " || " + file.length);
            String fileName=  UUID.randomUUID().toString();
            
            stream = new FileOutputStream("c:\\bit\\"+fileName+".png");
            stream.write(file);
            stream.close();
            System.out.println("파일 작성 완료");
            mav.addObject("msg","ok");
            
        }catch(Exception e){
            System.out.println("파일이 정상적으로 넘어오지 않았습니다");
            mav.addObject("msg","no");
            return mav;
        }finally{
            stream.close();
        }
        return mav;
        
    }
*/
}
