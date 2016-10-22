package winder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("filterDAO")
public class FilterDAOImpl {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insertFilter(String fword) throws RuntimeException{
		return sqlSession.insert("winder.FilterCheck.insertFilter", fword);
	}
	
	public List<String> listFilster() throws RuntimeException{
		return sqlSession.selectList("winder.FilterCheck.listFilter");
	}

}
