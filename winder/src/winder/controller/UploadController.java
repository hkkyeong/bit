package winder.controller;

import javax.activation.CommandMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import winder.service.UploadFileService;

@Controller
public class UploadController {
	
	@Autowired
	UploadFileService uploadFileService;
	
	@RequestMapping(value="uploadForm")
	public String uploadForm(){
		return "mypage/upload";
	}
	
	//파일 업로드
	@RequestMapping(value="insertFile")
	public ModelAndView insertFile(CommandMap commandMap, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/sample/openBoardList.do");
	     
	    uploadFileService.insertFile(commandMap.getMap(), request);
	     
	    return mv;
	}
}
