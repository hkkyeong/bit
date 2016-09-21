package winder.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface UploadFileService {
	
	void insertFile(Map<String, Object> map, HttpServletRequest request) throws Exception;

}
