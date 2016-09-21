package winder.dao;
import java.util.List;
import winder.vo.NoteVO;

public interface NoteDAO {

	public int insertNote(NoteVO note);
	public List<NoteVO> selectNoteList(String rid) throws RuntimeException;
	public int deleteNote(int nno);
	public NoteVO selectNote(int nno);
}
 