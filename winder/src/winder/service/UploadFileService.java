package winder.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface UploadFileService {
	
	void insertFile(Map<String, Object> map, HttpServletRequest request, HttpSession session) throws Exception;
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception ;
	public Map<String, Object> selectFileDetail(Map<String, Object> map) throws Exception ;
	Map<String, Object> selectFileInfo(int uno) throws Exception;
}
