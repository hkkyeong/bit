package winder.controller;
import java.util.List;
import java.util.Queue;
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
import winder.service.ScrapServiceImpl;
import winder.vo.ScrapVO;
import winder.vo.TeamVO;

@Controller
public class ScrapController {

	@Autowired 
	private ScrapServiceImpl scrapService;

	private Queue<String> queueOfURL;


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

		scrap.setUrl(url);
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
		/*String articleURL = "http://m.blog.naver.com/sara1428/220803352441"; */
		Document doc = Jsoup.connect(articleURL).get();     // document 객체 생성.

		Elements title = doc.select("div#viewTypeSelector.post_ct");          // 아이디가 _article인 div 태그 선택
		System.out.println("title: " + title);


		String imgSrc = doc.select("img").attr("src");
		System.out.println(imgSrc);
		request.setAttribute("img",imgSrc); 
		
		
		
		
		/* Elements con = doc.select("div.se_component se_paragraph default"); */  
		String str = title.text();                            // 값 저장
		/*String imgs = */
		System.out.println("str:"+str);  

		model.addAttribute("str2", str);
		request.setAttribute("str",str);		    

		return "scrap/scrap2";
	}

	@RequestMapping(value="scrapList")
	public String scrapList(Model model, HttpSession session, HttpServletRequest request){
		String id=(String)session.getAttribute("id");

		Object pno =request.getParameter("pno");
		request.setAttribute("pno",pno);

		model.addAttribute("scrapList",scrapService.selectScrapList(id));
		model.addAttribute("selectProject",scrapService.selectProject(id));

		return "scrap/scrapList";
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
