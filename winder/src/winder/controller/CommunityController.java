package winder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.BoardService;

@Controller
public class CommunityController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="community")
	public String community(Model model){
		return "community/community";
	}

}
