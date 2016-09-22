package winder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import winder.service.UploadFileService;

@Controller
public class UploadController {
	
	@Autowired
	UploadFileService uploadFileService;
	
	@RequestMapping(value="uploadForm")
	public String uploadForm()
	{
		return "mypage/upload";
	}
	
	//파일 업로드
	@RequestMapping(value="insertFile")
	public ModelAndView insertFile(MultipartHttpServletRequest mRequest) throws Exception{
	    
		ModelAndView mv = new ModelAndView();
		
		if(uploadFileService.insertFile(mRequest)){
			mv.addObject("result", "성공");
		}else{
			mv.addObject("result","실패");
		}
		mv.setViewName("mypage/upload");
	     
	    return mv;
	}
}
