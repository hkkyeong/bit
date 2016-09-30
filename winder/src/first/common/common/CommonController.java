/*package first.common.common;

import java.io.File;
import java.net.URLEncoder;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import first.common.common.CommandMap;
import first.common.common.CommonService;

@Controller
public class CommonController {
	
	@Resource(name="commonService")
	private CommonService commonService;
	
	@RequestMapping(value="downloadFile")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception{
		Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
		String storedName = (String)map.get("STOREDNAME");
		String originalName = (String)map.get("ORIGINALNAME");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\비트\\file\\"+storedName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalName,"UTF-8")+"\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
}
*/