package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import winder.service.MemberService;
import winder.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	//회원 가입 처리
	@RequestMapping(value = "/signchk", method = { RequestMethod.POST, RequestMethod.GET })
	public String memberJoin(MemberVO vo, HttpSession session) {
		try {
			int count = memberService.insertMember(vo);
			if (count == 1) {

				return "redirect:/home";
			} else {
				return "redirect:/login";
			}
		} catch (Exception e) {
			return "redirect:/login";
		}

	}

	//회원 가입 form
	@RequestMapping(value = "/signup", method = { RequestMethod.GET, RequestMethod.POST })
	public String signup(HttpServletRequest req) {

		return "user/signup";

	}

}
