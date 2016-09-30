package winder.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import first.common.common.FileUtils;
import winder.dao.UploadDAOImpl;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	 FileUtils fileUtils =new FileUtils();

	@Autowired
	UploadDAOImpl uploadDAO; 
	

	@Override
	public Map<String, Object> selectFileInfo(int uno) throws Exception {
		System.out.println("Service selectFileInfo: "+ uno);
		return uploadDAO.selectFileInfo(uno);
	}
	

	@Override
	public void insertFile(Map<String, Object> map, HttpServletRequest request, HttpSession session) throws Exception {
		/*uploadDAO.insertFile(map);*/

		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request, session);
		for(int i=0, size=list.size(); i<size; i++){
			uploadDAO.insertFile(list.get(i));
		}
	}
	@Override
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception {
		return uploadDAO.selectFileList(map);
		
	}
	
	@Override
	public Map<String, Object> selectFileDetail(Map<String, Object> map) throws Exception {
		
		Map<String, Object> resultMap = new HashMap<String,Object>();
		Map<String, Object> tempMap = uploadDAO.selectFileDetail(map);
		resultMap.put("map",tempMap);
		System.out.println("tempMap"+tempMap);
		
		List<Map<String,Object>> list = uploadDAO.selectFileList(map);
		System.out.println("list"+list);
		resultMap.put("list", list);
		  
		return resultMap;
	}

	
} 
