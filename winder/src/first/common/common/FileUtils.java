package first.common.common;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileUtils {
	private static final String upath= "C:\\비트\\file\\";
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, HttpServletRequest request, HttpSession session) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
    	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

    	MultipartFile multipartFile = null;
    	String originalName  = null;
    	String originalFileExtension = null;
    	String storedName = null;
    	//String utitle =multipartHttpServletRequest.getParameter("utitle");
    	
    	//System.out.println(utitle);
    	
    	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 
        
        String uno = (String)map.get("uno");
        String utitle = (String)map.get("utitle");        
        
        File file = new File(upath);
        if(file.exists() == false){
        	file.mkdirs(); 
        }
        
        while(iterator.hasNext()){
        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        	if(multipartFile.isEmpty() == false){
        		originalName = multipartFile.getOriginalFilename();
        		originalFileExtension = originalName.substring(originalName.lastIndexOf("."));
        		storedName = getRandomString() + originalFileExtension;
        		String id=(String) session.getAttribute("id");
        		
        		file = new File(upath +storedName);
        		multipartFile.transferTo(file);
        		
        		listMap = new HashMap<String,Object>();
        		listMap.put("uno", uno);
        		listMap.put("utitle",utitle);
        		listMap.put("originalname", originalName);
        		listMap.put("storedname", storedName);
        		listMap.put("usize", multipartFile.getSize());
        		listMap.put("id",id);
        		//utitle 추가
        		
        		list.add(listMap);
        	}
        }
		return list;
	}
	
	
	
	
	
	
	
	
	public List<Map<String,Object>> parseInsertFileInfo2(Map<String,Object> map, HttpServletRequest request, HttpSession session) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
    	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

    	MultipartFile multipartFile = null;
    	String originalName  = null;
    	String originalFileExtension = null;
    	String storedName = null;

   
    	
    	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 

        String id =(String)map.get("id");
    	String password =(String)map.get("password");
    	String name =(String)map.get("name");
    	String email =(String)map.get("email");
    	String phone =(String)map.get("phone");
        
        File file = new File(upath);
        if(file.exists() == false){
        	file.mkdirs(); 
        }
        
        while(iterator.hasNext()){
        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        	if(multipartFile.isEmpty() == false){
        		originalName = multipartFile.getOriginalFilename();
        		originalFileExtension = originalName.substring(originalName.lastIndexOf("."));
        		storedName = getRandomString() + originalFileExtension;
        		
        		file = new File(upath +originalName);
        		multipartFile.transferTo(file);
        		
        		listMap = new HashMap<String,Object>();
        		listMap.put("id", id);
        		listMap.put("password",password);
        		listMap.put("name", name);
        		listMap.put("email", email);
        		listMap.put("phone",phone);
        		listMap.put("mimg", originalName);
        		
        		list.add(listMap);
        	}
        }
		return list;
	}
	
	
	
	public List<Map<String,Object>> parseInsertFileInfo3(Map<String,Object> map, HttpServletRequest request, HttpSession session) throws Exception{
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
    	Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

    	MultipartFile multipartFile = null;
    	String originalName  = null;
    	String originalFileExtension = null;
    	String storedName = null;

   
    	
    	List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null; 

    	String name =(String)map.get("name");
    	String code =(String)map.get("code");
        
        File file = new File(upath);
        if(file.exists() == false){
        	file.mkdirs(); 
        }
        
        while(iterator.hasNext()){
        	multipartFile = multipartHttpServletRequest.getFile(iterator.next());
        	if(multipartFile.isEmpty() == false){
        		originalName = multipartFile.getOriginalFilename();
        		originalFileExtension = originalName.substring(originalName.lastIndexOf("."));
        		storedName = getRandomString() + originalFileExtension;
        		
        		file = new File(upath +originalName);
        		multipartFile.transferTo(file);
        		
        		listMap = new HashMap<String,Object>();
        		listMap.put("name", name);
        		listMap.put("code", code);
        		listMap.put("timg", originalName);
        		
        		list.add(listMap);
        	}
        }
		return list;
	}
	
	
	
	
	
	
}