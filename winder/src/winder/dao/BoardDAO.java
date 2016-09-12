package winder.dao;

import java.util.List;

import winder.vo.BoardVO;

public interface BoardDAO {
	public int insertBoard(BoardVO board) throws RuntimeException;
	public int deleteBoard(int bno);
	public int updateBoard(BoardVO board);
	
	public List<BoardVO> selectAllBoard();	// 전체 게시글.
}
