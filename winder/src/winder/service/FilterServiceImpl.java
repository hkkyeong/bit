package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.FilterDAOImpl;

@Service
public class FilterServiceImpl {
	
	@Autowired
	private FilterDAOImpl filterDAO;
	
	public int insertFilter(String fword) throws RuntimeException{
		return filterDAO.insertFilter(fword);
	}
	
	public List<String> listFilter() throws RuntimeException{
		return filterDAO.listFilster();
	}

}
