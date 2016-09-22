package winder.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.TodoListService;
import winder.service.TodoService;
import winder.vo.TodoJoinVO;

@Controller
public class ProgressController {
	@Autowired
	private TodoListService todolistService;
	@Autowired
	private TodoService todoService;

	@RequestMapping(value = "wholeprogress")
	public String wholeProgress(Model model, HttpServletRequest request) {
		// 프로젝트 진행률
		int temp = 0;
		List<TodoJoinVO> plist = todolistService.selectTodoList(Integer.parseInt(request.getParameter("pno")));
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getState().equals("2")) {
				temp++;
			}
		}
		double per = (double) temp / (double) plist.size() * 100.0;
		model.addAttribute("per", (int) per);
		model.addAttribute("done", temp);
		model.addAttribute("size", plist.size());

		return "project/wholeprogress";
	}

}