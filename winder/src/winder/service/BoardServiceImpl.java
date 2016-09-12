package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.BoardDAO;
import winder.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public int insertBoard(BoardVO board) throws RuntimeException {
		// TODO Auto-generated method stub
		return boardDAO.insertBoard(board);
	}

	@Override
	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.deleteBoard(bno);
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return boardDAO.updateBoard(board);
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		// TODO Auto-generated method stub
		return boardDAO.selectAllBoard();
	}


	
}
