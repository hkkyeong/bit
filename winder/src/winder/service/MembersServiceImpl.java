package winder.service;

import java.util.List;

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
	

}
