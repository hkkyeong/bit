package winder.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import winder.dao.NoteDAOImpl;
import winder.vo.NoteVO;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteDAOImpl noteDAO;
	
	public int insertNote(NoteVO note) throws RuntimeException{
		return noteDAO.insertNote(note);
	}
	public List<NoteVO> selectNoteList(String rid) {
		return noteDAO.selectNoteList(rid);
	}
	public int deleteNote(int nno) {
		return noteDAO.deleteNote(nno);
	}
	public NoteVO selectNote(int nno) throws RuntimeException {
		return noteDAO.selectNote(nno);  
	}
}
