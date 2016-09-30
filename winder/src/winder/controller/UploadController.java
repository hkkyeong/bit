package winder.controller;
import first.common.common.CommandMap;
import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import winder.service.ProjectService;
import winder.service.ScrapServiceImpl;
import winder.service.UploadFileService;

@Controller
public class UploadController {

	@Autowired
	UploadFileService uploadFileService; 
	@Autowired 
	private ScrapServiceImpl scrapService;
	@Autowired 
	ProjectService projectService;
	
	@RequestMapping(value="testMapArgumentResolver")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            System.out.println("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	@RequestMapping(value="downloadFile")
	public void downloadFile( HttpServletResponse response,HttpServletRequest request) throws Exception{
		CommandMap commandMap=new CommandMap();
		commandMap.put("UNO", request.getParameter("UNO"));
		
		int uno =Integer.parseInt(request.getParameter("UNO"));
		Map<String,Object> map = uploadFileService.selectFileInfo(uno);
		
		String storedName = (String)map.get("STOREDNAME");
		String originalName = (String)map.get("ORIGINALNAME");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\비트\\file\\"+storedName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	@RequestMapping(value="uploadForm")
	public String uploadForm(){
		return "mypage/upload";   
	}  

	@RequestMapping(value="insertFile", method=RequestMethod.POST)
	public ModelAndView insertFile(CommandMap commandMap, HttpServletRequest request,HttpSession session) throws Exception{	    
		ModelAndView mv = new ModelAndView("redirect:/uploadForm");
		uploadFileService.insertFile(commandMap.getMap(), request,session);
		return mv;
	}

	@RequestMapping(value="scrapList")
	public ModelAndView selectFileList(Model model, HttpSession session,HttpServletRequest request,CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/mypage/uploadList2");

		List<Map<String,Object>> list = uploadFileService.selectFileList(commandMap.getMap());
		mv.addObject("list", list);

		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		model.addAttribute("selectProject",scrapService.selectProject(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));

		
		return mv;
	}

	@RequestMapping(value="uploadDetail")
	public ModelAndView fileDetail(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView("/mypage/uploadDetail");
		int uno =Integer.parseInt(request.getParameter("uno"));
		String storedName = request.getParameter("storedname");
		CommandMap commandMap=new CommandMap();
		commandMap.put("uno", uno);
		commandMap.put("storedname", storedName);

		Map<String,Object> map = uploadFileService.selectFileDetail(commandMap.getMap());
		mv.addObject("map", map.get("map"));

		return mv;
	}
}