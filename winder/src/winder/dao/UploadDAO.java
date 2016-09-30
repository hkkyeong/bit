package winder.dao;

import java.util.Map;

public interface UploadDAO {
	public int insertFile(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectFileDetail(Map<String, Object> map) throws Exception;
	public Map<String, Object> selectFileInfo(int uno) throws Exception;
}
