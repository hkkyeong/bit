package winder.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import winder.service.ProjectService;
import winder.service.ScrapServiceImpl;
import winder.service.UploadFileService;
import winder.vo.ScrapVO;

@Controller
public class ScrapController {

	@Autowired 
	private ScrapServiceImpl scrapService;
	@Autowired ProjectService projectService;
	private String firstImageSrc ;
	@Autowired
	UploadFileService uploadFileService; 
 
	@RequestMapping(value="scrapForm")
	public String scrapForm(HttpServletResponse resp,HttpServletRequest request,Model model) throws Exception{
		String url= request.getParameter("url");
		return "scrap/scrap";
	}

	@RequestMapping(value="insertScrap")
	public String insertScrap(HttpServletRequest request,Model model,HttpSession session) throws Exception{
		ScrapVO scrap=new ScrapVO();
		String url= request.getParameter("url");
		String id = (String) session.getAttribute("id");

		StringBuffer sb = new StringBuffer();
		sb.append(url);
		sb.insert(7,"m.");

		String url2 = sb.toString();
		scrap.setUrl(url2);
		scrap.setId(id);
		scrap.setStitle(request.getParameter("stitle"));
		scrap.setPno(0);

		String articleURL = "http://m.blog.naver.com/potter777777/220605598446"; 
		Document doc = Jsoup.connect(url).get();     // document 객체 생성.
		Elements ele = doc.select("div.se_textView");          // 아이디가 _article인 div 태그 선택
		String str = ele.text();                            // 값 저장

		int count=scrapService.insertScrap(scrap);
		if(count==1){

			return "redirect:/scrapList";
		}else{
			return "scrap/scrap";
		}
	} 


	@RequestMapping(value="scrap1")
	public String scrap1(HttpServletResponse resp,HttpServletRequest request,Model model) throws Exception{
		int sno =Integer.parseInt(request.getParameter("sno"));
		ScrapVO scrap =scrapService.selectScrapNoList(sno);		
		String articleURL  = scrap.getUrl();
		Document doc = Jsoup.connect(articleURL).get();     // document 객체 생성.
		Elements title = doc.select("h3");


		if("div.post_ct".contains((CharSequence) doc.toString())){
			Elements content2 =doc.select("div.post_ct");
			String ab=content2.toString();
			String abb;
			abb=ab.replaceAll("span class=\"_img _inl fx\" thumburl", "img src");
			abb=abb.replaceAll("?type=\"></span>", "?type=w2\"></img>");
			
			String conS = content2.text();
			request.setAttribute("content",conS);

		}else{     
			Elements content =doc.select("div#viewTypeSelector.post_ct");  
			String ab=content.toString();
			String abb;
			
			//이미지 태그 조정
			abb=ab.replaceAll("span class=\"_img _inl fx\" thumburl", "img src");
			abb=abb.replaceAll("\\?type=\"></span>", "?type=w2\"></img>");
			
			model.addAttribute("scrapcontent", abb);

			String conS = content.text();
			request.setAttribute("content",conS);
		}

  
		Elements el = doc.select("div.post_ct span._img fx");  
		for(Element element : el){
			request.setAttribute("img",element.attr("src").toString());
		}
  
		String titleS = title.text();                            // 값 저장
		request.setAttribute("title",titleS);		   

		request.setAttribute("img",firstImageSrc); 
		if(request.getParameter("kind").equals("pro")){	
			model.addAttribute("kind", "pro");
		}else{
			model.addAttribute("kind", "my");
		}
		return "scrap/scrapcontent";
		//return "scrap/scrap2";
	}

	@RequestMapping(value="scrapList11")
	public String scrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		model.addAttribute("selectProject",scrapService.selectProject(id));
		model.addAttribute("projectmenu", projectService.selectProjectMenu(id));

		return "mypage/uploadList2";
		//return "scrap/myScrap";
	}

	@RequestMapping(value="sharedscrapList")
	public String sharedscrapList(Model model, HttpSession session, HttpServletRequest request){
		int pno =Integer.parseInt(request.getParameter("pno"));
		request.setAttribute("pno",pno);
		model.addAttribute("sharedscrapList",scrapService.sharedscrapList(pno));
		
		int boardno =Integer.parseInt(request.getParameter("pno"));
		request.setAttribute("boardno",boardno);
		model.addAttribute("sharedFileList",uploadFileService.sharedFileList(boardno));

		return "project/sharingdata";
	}

	@RequestMapping(value="my")
	public String myScrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		return "scrap/scrapList";
	}


	@RequestMapping(value="shareScrap")
	//scrap vo 받아올 필요가 있으려나~?
	public String shareScrap(ScrapVO scrap,HttpServletRequest request,Model model,HttpSession session) throws Exception{
		//String id=(String)session.getAttribute("id");
		String[] share= request.getParameterValues("share");				
		int pno= Integer.parseInt(request.getParameter("pno")); 
		String[] sno =request.getParameterValues("sno");

		for(int i=0; i<sno.length;i++){
			ScrapVO scrapList  =scrapService.selectScrapNoList(Integer.parseInt(sno[i]));
			scrapList.setPno(pno);
			scrapService.shareScrap(scrapList);
		}

		return "redirect:/scrapList";
	}



}