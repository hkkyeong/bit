package winder.service;

import java.util.List;

import winder.vo.NoteVO;

public interface NoteService {
	public int insertNote(NoteVO note);
	public List<NoteVO> selectNoteList(String rid);
	public int deleteNote(int nno);
	public NoteVO selectNote(int nno) throws RuntimeException;
	public int insertCheck(NoteVO vo) throws RuntimeException;

}
