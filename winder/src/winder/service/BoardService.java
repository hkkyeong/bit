package winder.service;

import java.util.List;

import winder.vo.BoardVO;

public interface BoardService {

	public int insertBoard(BoardVO board) throws RuntimeException;
	public int deleteBoard(int bno);
	public int updateBoard(BoardVO board);
	
	public List<BoardVO> selectAllBoard();
}
