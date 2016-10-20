package winder.dao;

import java.util.List;
import java.util.Map;

import winder.vo.UploadfileVO;

public interface UploadDAO {
	public int insertFile(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> selectFileDetail(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectFileInfo(int uno) throws Exception;
	public int shareFile(UploadfileVO vo) throws Exception; 
	public List<UploadfileVO> sharedFileList(int uno)  throws RuntimeException;
	public List<UploadfileVO> listFile() throws RuntimeException;
}
