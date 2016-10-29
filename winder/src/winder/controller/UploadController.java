package winder.controller;
import first.common.common.CommandMap;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import winder.service.ProjectService;
import winder.service.ScrapServiceImpl;
import winder.service.TeamService;
import winder.service.UploadFileService;
import winder.vo.TeamVO;
import winder.vo.UploadfileVO;

@Controller
public class UploadController {

	@Autowired
	UploadFileService uploadFileService; 
	@Autowired 
	private ScrapServiceImpl scrapService;
	@Autowired 
	ProjectService projectService;
	@Autowired 
	private TeamService teamService;
	
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
		System.out.println("uno:"+uno);
		Map<String,Object> map = uploadFileService.selectFileInfo(uno);
		
		String storedName = (String)map.get("STOREDNAME");
		String originalName = (String)map.get("ORIGINALNAME");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\bit\\file\\"+storedName));
		
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
		ModelAndView mv = new ModelAndView("redirect:/scrapList");
		//String utitle= request.getParameter("utitle");
		//System.out.println(utitle);
		commandMap.put("utitle",request.getParameter("utitle"));
		//System.out.println(commandMap.getMap());
		uploadFileService.insertFile(commandMap.getMap(), request, session);
		return mv;
	}

	@RequestMapping(value="scrapList")
	public ModelAndView selectFileList(Model model, HttpSession session,HttpServletRequest request,CommandMap commandMap) throws Exception{
		ModelAndView mv = new ModelAndView("/mypage/uploadList2");
		String id=(String)session.getAttribute("id");

		List<Map<String,Object>> list = uploadFileService.selectFileList(commandMap.getMap());
		mv.addObject("list", list);

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
	
	@RequestMapping(value="shareFile")
	public String shareFile(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		
		int boardno= Integer.parseInt(request.getParameter("boardno")); 
		String[] uno =request.getParameterValues("uno");

		for(int i=0; i<uno.length;i++){
			UploadfileVO fileList  =uploadFileService.selectFileList(Integer.parseInt(uno[i]));
			fileList.setBoardno(boardno);
			uploadFileService.shareFile(fileList);
		}

		return "redirect:/scrapList";
	}
	
	@RequestMapping(value="sharedFileList")
	public String sharedFileList(Model model, HttpSession session, HttpServletRequest request){
		//String id=(String)session.getAttribute("id");

		int boardno =Integer.parseInt(request.getParameter("pno"));
		request.setAttribute("boardno",boardno);

		model.addAttribute("sharedFileList",uploadFileService.sharedFileList(boardno));

		return "project/sharingdata";
	}
	
	@RequestMapping(value="insertFile2", method=RequestMethod.POST)
	public ModelAndView insertFile2(CommandMap commandMap, HttpServletRequest request,HttpSession session) throws Exception{	    
		ModelAndView mv = new ModelAndView("redirect:/home");
		commandMap.put("id",request.getParameter("id"));
		commandMap.put("password",request.getParameter("password"));
		commandMap.put("name",request.getParameter("name"));
		commandMap.put("email",request.getParameter("email"));
		commandMap.put("phone",request.getParameter("phone"));
		System.out.println("###### "+commandMap.getMap());
		uploadFileService.insertFile2(commandMap.getMap(), request, session);
		return mv;
	}
	
	//팀 생성
	@RequestMapping(value="teamCreate",method = { RequestMethod.POST, RequestMethod.GET } )
	public ModelAndView teamCreate(CommandMap commandMap, HttpServletRequest request,HttpSession session) throws Exception{	    
		ModelAndView mv = new ModelAndView("redirect:/home");
		TeamVO vo=new TeamVO();
		Date d= new Date(); 
		int code = (int) d.getTime();
		
		commandMap.put("code",code);
		commandMap.put("name",request.getParameter("name"));
		uploadFileService.insertFile3(commandMap.getMap(), request, session);
		
		//members 추가
		vo=teamService.selectTno(Integer.toString(code));
		return mv;
	}
}