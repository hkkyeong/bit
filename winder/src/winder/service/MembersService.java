package winder.service;

import java.util.List;
import winder.vo.MembersVO;

public interface MembersService {
	
	public int insertMembers(MembersVO members) throws RuntimeException;
	public int deleteMembers(int mno);
	public int updateMembers(MembersVO members);
	public MembersVO selectMembers(int mno);
	public List<MembersVO> selectAllMembers();
	public List<MembersVO> teamMember(String pno);
}
