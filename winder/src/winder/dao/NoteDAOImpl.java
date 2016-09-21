package winder.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import winder.vo.NoteVO;

@Repository("noteDAO")
public class NoteDAOImpl implements NoteDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	
	@Override
	public int insertNote(NoteVO note) {
		return sqlSession.insert("winder.Note.insertNote", note);
	}
	@Override
	public List<NoteVO> selectNoteList(String rid) throws RuntimeException {
		return sqlSession.selectList("winder.Note.selectNoteList", rid);
	}
	@Override
	public int deleteNote(int nno) {
		return sqlSession.delete("winder.Note.deleteNote", nno);
	}
	@Override
	public NoteVO selectNote(int nno){
		return sqlSession.selectOne("winder.Note.selectNote", nno);
	}

}
