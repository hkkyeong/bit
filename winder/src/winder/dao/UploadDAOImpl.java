package winder.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("uploadDAO")
public class UploadDAOImpl implements UploadDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Map<String, Object> selectFileInfo(int uno) throws Exception{
		return (Map<String, Object>)selectOne("winder.Uploadfile.selectFileInfo", uno);
	}

	
	public int insertFile(Map<String, Object> map) throws Exception{
		return sqlSession.insert("winder.Uploadfile.insertFile", map);
	}
	
	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
	
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("winder.Uploadfile.selectFileList", map);
	}
	
	public Object selectOne(String queryId, Object params){
		return sqlSession.selectOne(queryId, params);
	}
	
	public Map<String, Object> selectFileDetail(Map<String, Object> map) throws Exception{
		return (Map<String, Object>) selectOne("winder.Uploadfile.fileDetail", map);
	}

}
