package winder.dao;

import java.util.List;
import java.util.Map;

import winder.vo.MembersVO;

public interface MembersDAO {

	public int insertMembers(MembersVO members) throws RuntimeException;

	public int deleteMembers(int mno);

	public int updateMembers(MembersVO members);

	public MembersVO selectMembers(int mno);

	public List<MembersVO> selectAllMembers();

	public List<MembersVO> teamMember(String pno);

	// id를 통해 tno를 구하기 위해
	public MembersVO selectMembersTno(String id);

	// projectmanagement의 접근 권한을 확인하기 위해, id와 tno를 이용하여 members테이블의 position값을
	// 구한다.
	public MembersVO selectMembersPosition(MembersVO members);

	public List<MembersVO> selectAllMembersTno(int tno);
	
	public int deleteMembersTeamOut(MembersVO members);
	public List<MembersVO> selectTeamMember(int tno);

	public int inviteM(MembersVO members) throws RuntimeException;
	
	public List<MembersVO> selectMembers2(String id) throws RuntimeException;
	
	public MembersVO selectMembersTnoS(String id);
}
