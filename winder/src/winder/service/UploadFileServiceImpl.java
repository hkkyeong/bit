/*package winder.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadFileServiceImpl implements UploadFileService {
 
	@Override
	public boolean insertFile(MultipartHttpServletRequest mRequest) throws Exception {

		boolean isSuccess = false;
		String uploadPath = "/비트/file";
		File dir = new File(uploadPath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {

			String uploadFileName = iter.next();
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			String originalFileName = mFile.getOriginalFilename();
			String saveFileName = originalFileName;

			if(saveFileName != null && !saveFileName.equals("")) {

				if(new File(uploadPath + saveFileName).exists()) {
					saveFileName = saveFileName + "_" + System.currentTimeMillis();
				}

				try {
					mFile.transferTo(new File(uploadPath + saveFileName));
					isSuccess = true;				

				} catch (IllegalStateException e) {
					e.printStackTrace();
					isSuccess = false;
				} catch (IOException e) {
					e.printStackTrace();
					isSuccess = false;
				}
			} 
		} 
		return isSuccess;
	}

}
*/