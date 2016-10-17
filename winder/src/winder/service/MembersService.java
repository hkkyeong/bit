package winder.service;

import java.util.List;
import java.util.Map;

import winder.vo.MembersVO;

public interface MembersService {
	
	public int insertMembers(MembersVO members) throws RuntimeException;
	public int deleteMembers(int mno);
	public int updateMembers(MembersVO members);
	public MembersVO selectMembers(int mno);
	public List<MembersVO> selectAllMembers();
	public List<MembersVO> teamMember(String pno);
	public int deleteMembersTeamOut(MembersVO members);
	public MembersVO selectMembersTno(String id); 
	// projectmanagement의 권한을 확인하기 위해.
	public MembersVO selectMembersPosition(MembersVO members);
	
	public List<MembersVO> selectAllMembersTno(int tno);
	public List<MembersVO> selectTeamMember(int tno);
	/*public List<Map<String, Object>> selectTeamMember(int tno);*/
	public int inviteM(MembersVO members) throws RuntimeException;
}
