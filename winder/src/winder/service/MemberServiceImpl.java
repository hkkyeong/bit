package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.MemberDAO;
import winder.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int insertMember(MemberVO member) throws RuntimeException {
		return memberDAO.insertMember(member);
	}

	@Override
	public int deleteMember(String id) {
		return memberDAO.deleteMember(id);
	}

	@Override
	public int updateMember(MemberVO member) {
		return memberDAO.updateMember(member);
	}

	@Override
	public MemberVO selectMember(String id) {
		return memberDAO.selectMember(id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		return memberDAO.selectAllMember();
	}

	@Override
	public int chkMember(MemberVO member) throws RuntimeException {
		return memberDAO.chkMember(member);
	}

	@Override
	public int updatePassword(MemberVO member) {
		return memberDAO.updatePassword(member);
	}

	@Override
	public int countMember() throws RuntimeException {
		return memberDAO.countMember();
	}
	
}
