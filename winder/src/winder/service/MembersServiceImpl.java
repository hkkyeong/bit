package winder.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.MembersDAO;
import winder.vo.MembersVO;

@Service
public class MembersServiceImpl implements MembersService{
	
	@Autowired
	private MembersDAO membersDAO;

	@Override
	public int insertMembers(MembersVO members) throws RuntimeException {
		return membersDAO.insertMembers(members);
	}

	@Override
	public int deleteMembers(int mno) {
		return membersDAO.deleteMembers(mno);
	}

	@Override
	public int updateMembers(MembersVO members) {
		return membersDAO.updateMembers(members);
	}

	@Override
	public MembersVO selectMembers(int mno) {
		return membersDAO.selectMembers(mno);
	}

	@Override
	public List<MembersVO> selectAllMembers() {
		return membersDAO.selectAllMembers();
	}

	@Override
	public List<MembersVO> teamMember(String pno) {
		return membersDAO.teamMember(pno);
	}

	@Override
	public int deleteMembersTeamOut(MembersVO members) {
		return membersDAO.deleteMembersTeamOut(members);
	}

	@Override
	public MembersVO selectMembersTno(String id) {
		return membersDAO.selectMembersTno(id);
	}

	@Override
	public MembersVO selectMembersPosition(MembersVO members) {
		return membersDAO.selectMembersPosition(members);
	}

	@Override
	public List<MembersVO> selectAllMembersTno(int tno) {
		return membersDAO.selectAllMembersTno(tno);
	}
	
	@Override
	public List<MembersVO> selectTeamMember(int tno) {
		return membersDAO.selectTeamMember(tno);
	}
	
	@Override
	public int inviteM(MembersVO members) throws RuntimeException {
		return membersDAO.inviteM(members);
	}
	
	public List<MembersVO> selectMembers2(String id){
		return membersDAO.selectMembers2(id);
	}

	@Override
	public MembersVO selectMembersTnoS(String id) {
		return membersDAO.selectMembersTnoS(id);
	}

}
