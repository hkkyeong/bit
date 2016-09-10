package winder.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import winder.service.MemberService;
import winder.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	DefaultFileRenamePolicy dfrp = new DefaultFileRenamePolicy();

	//회원 가입 처리
	@RequestMapping(value = "/signchk", method = { RequestMethod.POST, RequestMethod.GET })
	public String memberJoin(MemberVO vo, HttpSession session, HttpServletRequest request) throws IOException {
		
		//vo =new MemberVO();
		String path ="C:\\비트\\workspace\\0901\\0830\\WebContent\\upload\\";
		int size = 1024*1024*5;
		String enc ="utf-8";

		MultipartRequest multi =new MultipartRequest(request,path,size,enc,dfrp);
		String name =multi.getParameter("name");
		String id =multi.getParameter("id");
		String password =multi.getParameter("password");
		String email =multi.getParameter("email");
		String phone =multi.getParameter("phone");
		String position =multi.getParameter("position");
		String mimg=multi.getFilesystemName("mimg");

		vo.setName(name);
		vo.setId(id);
		vo.setPassword(password);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setPosition(position);
		vo.setMimg(mimg);
				
		try {
			int count = memberService.insertMember(vo);
			if (count == 1) {
				return "redirect:/home";
			} else {
				return "redirect:/signupForm";
			}
		} catch (Exception e) {
			return "redirect:/signupForm";
		}

	}

	//회원 가입 form
	@RequestMapping(value = "/signupForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup(HttpServletRequest req) {
		return "signupForm";
	}

}
