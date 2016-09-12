package winder.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import winder.vo.BoardVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{

	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertBoard(BoardVO board) throws RuntimeException {
		// TODO Auto-generated method stub
		return sqlSession.insert("winder.Board.insertBoard", board);
	}

	@Override
	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return sqlSession.delete("winder.Board.deleteBoard", bno);
	}

	@Override
	public int updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		return sqlSession.update("winder.Board.udpateBoard",board);
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("winder.Board.selectAllBoard");
	}


	
	
}
