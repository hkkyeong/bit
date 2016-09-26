package winder.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import winder.service.ScrapServiceImpl;
import winder.vo.AbcVO;
import winder.vo.ScrapVO;

@Controller
public class ScrapController {

	@Autowired 
	private ScrapServiceImpl scrapService;
	private String firstImageSrc ;

	@RequestMapping(value="scrapForm")
	public String scrapForm(HttpServletResponse resp,HttpServletRequest request,Model model) throws Exception{
		String url= request.getParameter("url");
		return "scrap/scrap";
	}

	/*	@RequestMapping(value="scrapList")
	public String scrapList(HttpServletResponse resp,HttpServletRequest request,Model model) throws Exception{
		String url= request.getParameter("url");

	        return "scrap/scrapList";
	}*/

	@RequestMapping(value="scrap")
	public String scrap(ScrapVO scrap,HttpServletRequest request,Model model,HttpSession session) throws Exception{
		/*String url= request.getParameter("url");*/
		String url = "http://m.blog.naver.com/potter777777/220605598446"; 
		String id = (String) session.getAttribute("id");
		/*int pno = (int)request.getAttribute("pno");*/

		scrap.setUrl(url);
		scrap.setId(id);
		/*scrap.setPno(pno);*/

		/*String articleURL = "http://m.blog.naver.com/potter777777/220605598446"; */
		Document doc = Jsoup.connect(url).get();     // document 객체 생성.
		Elements ele = doc.select("div.se_textView");          // 아이디가 _article인 div 태그 선택
		String str = ele.text();                            // 값 저장
		System.out.println(str); 

		try {
			int count=scrapService.insertScrap(scrap);
			if(count==1){
				model.addAttribute("str", str);
				request.setAttribute("str",str);
				return "redirect:/scrapList";
			}else{
				return "scrap/scrap";
			}
		} catch (Exception e) {
			return "scrap/scrap";
		}


	}

	@RequestMapping(value="insertScrap")
	public String insertScrap(ScrapVO scrap,HttpServletRequest request,Model model,HttpSession session) throws Exception{
		String url= request.getParameter("url");
		String id = (String) session.getAttribute("id");

		StringBuffer sb = new StringBuffer();
		sb.append(url);
		sb.insert(7,"m.");
		System.out.println(sb);

		String url2 = sb.toString();
		scrap.setUrl(url2);
		scrap.setId(id);

		/*String articleURL = "http://m.blog.naver.com/potter777777/220605598446"; */
		Document doc = Jsoup.connect(url).get();     // document 객체 생성.
		Elements ele = doc.select("div.se_textView");          // 아이디가 _article인 div 태그 선택
		String str = ele.text();                            // 값 저장
		System.out.println(str); 

		int count=scrapService.insertScrap(scrap);
		System.out.println("count ="+count);
		if(count==1){
			model.addAttribute("str", str);
			request.setAttribute("str",str);
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
			AbcVO vo=new AbcVO();
			String ab=content2.toString();
			String abb;
			//abb=ab.replaceAll("span", "img");
			abb=ab.replaceAll("span class=\"_img _inl fx\" thumburl", "img src");
			abb=abb.replaceAll("?type=\"></span>", "?type=w2\"></img>");
			abb=abb.replaceAll("27일 철도와 지하철 동시 파업 돌입", "rrrrrr\"");
			vo.setAbc(abb);
			int count=scrapService.insertabc(vo);
			if(count==1){
				System.out.println("성공");
				List<AbcVO> abc=scrapService.selectabc(36);
				System.out.println(abc);
				model.addAttribute("abc", abc);
			}else{
				System.out.println("실패");
			}
			String conS = content2.text();
			request.setAttribute("content",conS);

		}else{     
			Elements content =doc.select("div#viewTypeSelector.post_ct");  
			AbcVO vo=new AbcVO();
			String ab=content.toString();
			String abb;
			abb=ab.replaceAll("span class=\"_img _inl fx\" thumburl", "img src");
			abb=abb.replaceAll("\\?type=\"></span>", "?type=w2\"></img>");
			abb=abb.replaceAll("27일 철도와 지하철 동시 파업 돌입", "ssssss\"");
			//abb=abb.replaceAll("27일 철도와 지하철 동시 파업 돌입", "ss\"");
			vo.setAbc(abb);
			//vo.setAbc(ab);
			int count=scrapService.insertabc(vo);
			if(count==1){
				System.out.println("성공");
				List<AbcVO> abc=scrapService.selectabc(36);
				System.out.println(abc);
				model.addAttribute("abc", abc);
			}else{
				System.out.println("실패");
			}
			String conS = content.text();
			request.setAttribute("content",conS);
		}

  
/*		Elements el = doc.select("div.post_ct span._img fx");  
		for(Element element : el){
			System.out.println(element.attr("src").toString().concat("w2"));
			request.setAttribute("img",element.attr("src").toString());
			System.out.println("22");
		}*/
  
		String titleS = title.text();                            // 값 저장
		request.setAttribute("title",titleS);		   


		/*request.setAttribute("test",test2);*/
		request.setAttribute("img",firstImageSrc); 

		return "abc";
		//return "scrap/scrap2";
	}

	@RequestMapping(value="scrapList")
	public String scrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		model.addAttribute("selectProject",scrapService.selectProject(id));

		return "scrap/myScrap";
	}

	@RequestMapping(value="sharedscrapList")
	public String sharedscrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		int pno =Integer.parseInt(request.getParameter("pno"));
		request.setAttribute("pno",pno);

		model.addAttribute("sharedscrapList",scrapService.sharedscrapList(pno));

		return "scrap/sharedscrapList";
	}

	@RequestMapping(value="my")
	public String myScrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		return "scrap/scrapList";
	}

	/*		@RequestMapping(value="selectProject")
		public String selectProject(Model model, HttpSession session, HttpServletRequest request){
			String id=(String)session.getAttribute("id");

			model.addAttribute("selectProject",scrapService.selectProject(id));
			return "scrap/scrapList";
		}*/

	@RequestMapping(value="shareScrap")
	public String shareScrap(ScrapVO scrap,HttpServletRequest request,Model model,HttpSession session) throws Exception{
		String id=(String)session.getAttribute("id");
		/*String[] share= request.getParameterValues("share");	*/			
		int pno= Integer.parseInt(request.getParameter("pno")); 
		String[] sno =request.getParameterValues("sno");

		for(int i=0; i<sno.length;i++){
			ScrapVO scrapList  =scrapService.selectScrapNoList(Integer.parseInt(sno[i]));
			scrapList.setPno(pno);
			scrapService.shareScrap(scrapList);

		}

		/*List<ScrapVO>   scrap2  =scrapService.selectScrapList(id);

			scrapService.shareScrap(scrap);
		 */


		/*
			String articleURL = "http://m.blog.naver.com/potter777777/220605598446"; 
			 Document doc = Jsoup.connect(url).get();     // document 객체 생성.
		        Elements ele = doc.select("div.se_textView");          // 아이디가 _article인 div 태그 선택
		        String str = ele.text();                            // 값 저장
		        System.out.println(str); 
			    try {
					int count=scrapService.insertScrap(scrap);
					if(count==1){
						model.addAttribute("str", str);
						request.setAttribute("str",str);
						return "redirect:/scrapList";
					}else{
						return "scrap/scrap";
					}
				} catch (Exception e) {
					return "scrap/scrap";
				}*/
		return "redirect:/scrapList";
	}



}
