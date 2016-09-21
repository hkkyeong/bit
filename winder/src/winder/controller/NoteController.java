package winder.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import winder.service.NoteService;
import winder.vo.NoteVO;

@Controller
public class NoteController {

	@Autowired 
	private NoteService noteService;

	@RequestMapping(value="noteForm")
	public String noteform() throws IOException{
		return "mypage/noteForm";
	}

	@RequestMapping(value="insertNote")
	public String noteCreate(NoteVO note, HttpServletRequest request) throws IOException{

		try {
			int count=noteService.insertNote(note);
			if(count==1){
				return "redirect:/noteList";
			}else{
				return "redirect:/index";
			}
		} catch (Exception e) {
			return "redirect:/signupForm";
		}
	}

	@RequestMapping(value="noteList")
	public String teamList(Model model, HttpSession session, HttpServletRequest request){
		String rid=(String)session.getAttribute("id");
		model.addAttribute("noteList",noteService.selectNoteList(rid));
		return "mypage/noteList";
	}

	@RequestMapping(value="noteDelete")
	public String noteDelete(Model model, HttpSession session, HttpServletRequest request){
		int nno =Integer.parseInt(request.getParameter("nno"));
		int result = noteService.deleteNote(nno);
		if(result==1){
			return "redirect:/noteList";
		}else{
			return "redirect:/";
		}
	} 

	@RequestMapping(value="noteDetail")
	public String noteDetail(Model model,HttpServletRequest request){
		int nno =Integer.parseInt(request.getParameter("nno"));
		model.addAttribute("noteDetail",noteService.selectNote(nno));
		return "mypage/noteDetail";
	}

}

