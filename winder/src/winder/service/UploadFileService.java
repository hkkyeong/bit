package winder.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadFileService {
	
	boolean insertFile(MultipartHttpServletRequest mRequest) throws Exception;

}
