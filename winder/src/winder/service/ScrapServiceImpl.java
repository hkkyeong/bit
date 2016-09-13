package winder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winder.dao.ScrapDAOImpl;
import winder.vo.ScrapVO;


@Service
public class ScrapServiceImpl {
	
	@Autowired
	private ScrapDAOImpl scrapDAO;
	
	public int insertScrap(ScrapVO scrap) throws RuntimeException{
		return scrapDAO.insertScrap(scrap);
	}
	
	public List<ScrapVO> selectScrapList(String id) throws RuntimeException {
		return scrapDAO.selectScrapList(id);
	}
	
	public List<ScrapVO> sharedscrapList(int pno)  throws RuntimeException {
		return scrapDAO.sharedscrapList(pno);
	}
	
	public List<ScrapVO> selectProject(String id){
		return scrapDAO.selectProject(id);
	}
		
	public int shareScrap(ScrapVO scrap) {
		return scrapDAO.shareScrap(scrap);
	}
	
	public ScrapVO selectScrapNoList(int sno)  throws RuntimeException {
		return scrapDAO.selectScrapNoList(sno);
	}

}
