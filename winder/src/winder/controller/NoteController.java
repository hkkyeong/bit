package winder.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import winder.service.NoteService;
import winder.service.TodoListService;
import winder.vo.NoteVO;
import winder.vo.TodoJoinVO;
import winder.vo.TodoListVO;

@Controller
public class NoteController {

	@Autowired 
	private NoteService noteService;
	@Autowired
	private TodoListService todolistService;

	@RequestMapping(value="noteForm")
	public String noteform() throws IOException{
		return "mypage/noteForm";
	}

	@RequestMapping(value="insertNote")
	public String noteCreate(NoteVO note, HttpServletRequest request) throws Exception{

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
	public String teamList(Model model, HttpSession session, HttpServletRequest request) throws Exception{
		System.out.println("notelist");
		String rid=(String)session.getAttribute("id");
		
		
		//날짜 지난 알림 쪽지 보내기
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		NoteVO vo=new NoteVO();
		vo.setNtitle("일정 알림");
		vo.setSid("manager");
		vo.setRid(rid);
		//접속자의 todolist 중 state=1인 리스트
		List<TodoListVO> tllist=todolistService.dateCheck(rid);
		for(int i=0; i<tllist.size(); i++){
			Date tldate=sdf.parse(tllist.get(i).getTldate());
			Date today=sdf.parse(sdf.format(new Date())); //오늘 날짜
			long l1=tldate.getTime();
			long l2=today.getTime();
			long ld=(l1-l2)/(24*60*60*1000);
			if(ld<0){
				try {
					int count=todolistService.countCheck(tllist.get(i).getTlno());
					if(count==1){//이미 알림 갔을 때
					}else{//알림 안 갔을 때 알림 추가
						System.out.println(i+" : "+tllist.get(i));
						todolistService.insertCheck(tllist.get(i));
						System.out.println("22222222");
						vo.setNcontent(tllist.get(i).getContent()+" 일정이 7일 남았습니다.");
						vo.setNdate(tllist.get(i).getTldate());
						System.out.println("33333");
						noteService.insertCheck(vo);
						System.out.println("4444444");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
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

