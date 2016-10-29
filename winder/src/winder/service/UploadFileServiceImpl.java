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
import winder.vo.TeamVO;
import winder.vo.UploadfileVO;

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
		//uploadDAO.insertFile(map);

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
		
		List<Map<String,Object>> list = uploadDAO.selectFileList(map);
		resultMap.put("list", list);
		  
		return resultMap;
	}
	
	public int shareFile(UploadfileVO vo) throws Exception {
		return uploadDAO.shareFile(vo);
	}
	
	public UploadfileVO selectFileList(int uno)  throws RuntimeException {
		return uploadDAO.selectFileList(uno);
	}

	public List<UploadfileVO> sharedFileList(int uno)  throws RuntimeException {
		return uploadDAO.sharedFileList(uno);
	}

	public List<UploadfileVO> listFile() throws RuntimeException {
		return uploadDAO.listFile();
	}
	
	@Override
	public void insertFile2(Map<String, Object> map, HttpServletRequest request, HttpSession session) throws Exception {
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo2(map, request, session);
		for(int i=0, size=list.size(); i<size; i++){
			uploadDAO.insertFile2(list.get(i));
		}
	}
	@Override
	public void insertFile3(Map<String, Object> map, HttpServletRequest request, HttpSession session) throws Exception {
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo3(map, request, session);
		for(int i=0, size=list.size(); i<size; i++){
			int count=uploadDAO.insertFile3(list.get(i));
		}
	}
} 





