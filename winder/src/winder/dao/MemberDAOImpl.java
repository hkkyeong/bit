package winder.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import winder.vo.MemberVO;
import winder.vo.OutMemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertMember(MemberVO member) throws RuntimeException {
		return sqlSession.insert("winder.Member.insertMember", member);
	}

	@Override
	public int deleteMember(String id) {
		return sqlSession.delete("winder.Member.deleteMember", id);
	}

	@Override
	public int updateMember(MemberVO member) {
		return sqlSession.update("winder.Member.updateMember", member);
	}

	@Override
	public MemberVO selectMember(String id) {
		return sqlSession.selectOne("winder.Member.selectMember",id);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		List<MemberVO> selectAllMember =new ArrayList<>();
		selectAllMember=sqlSession.selectList("winder.Member.selectAllMember");
		for(int i=0; i<selectAllMember.size(); i++){
			if(selectAllMember.get(i).getId().equals("manager")){
				selectAllMember.remove(i);
			}
		}
		return selectAllMember;
	}

	@Override
	public int chkMember(MemberVO member) throws RuntimeException {
		return sqlSession.selectOne("winder.Member.chkMember", member);
	}

	@Override
	public int updatePassword(MemberVO member) {
		return sqlSession.update("winder.Member.updatePassword",member);
	}

	@Override
	public int countMember() throws RuntimeException {
		return sqlSession.selectOne("winder.Member.countMember");
	}

	@Override
	public int todayJoin() throws RuntimeException {
		return sqlSession.selectOne("winder.Member.todayJoin");
	}

	@Override
	public int outMember(OutMemberVO outmember) throws RuntimeException {
		return sqlSession.insert("winder.OutMember.insertOutMember", outmember);
	}

	@Override
	public List<OutMemberVO> outMemberList() throws RuntimeException {
		return sqlSession.selectList("winder.OutMember.OutMemberList");
	}
	
	
}
