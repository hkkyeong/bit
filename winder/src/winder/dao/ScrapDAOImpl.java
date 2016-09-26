package winder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import winder.vo.AbcVO;
import winder.vo.ScrapVO;

@Repository("scrapDAO")
public class ScrapDAOImpl {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertScrap(ScrapVO scrap)  throws RuntimeException {
		return sqlSession.insert("winder.Scrap.insertScrap",scrap);
	}
	
	public List<ScrapVO> selectScrapList(String id)  throws RuntimeException {
		return sqlSession.selectList("winder.Scrap.selectScrapList",id);
	}
	public List<ScrapVO> sharedscrapList(int pno)  throws RuntimeException {
		return sqlSession.selectList("winder.Scrap.sharedscrapList",pno);
	}
	public List<ScrapVO> selectProject(String id)  throws RuntimeException {
		return sqlSession.selectList("winder.Scrap.selectProject",id);
	}
	
	public int shareScrap(ScrapVO scrap){
		return sqlSession.update("winder.Scrap.shareScrap",scrap);
	}
	
	public ScrapVO selectScrapNoList(int sno)  throws RuntimeException {
		return sqlSession.selectOne("winder.Scrap.selectScrapNoList",sno);
	}
	
	/* 추가 */
	public int insertabc(AbcVO vo){
		return sqlSession.insert("winder.Scrap.insertabc", vo);
	}
	
	public List<AbcVO> selectabc(int abcno){
		return sqlSession.selectList("winder.Scrap.selectabc", abcno);
	}
	
}
