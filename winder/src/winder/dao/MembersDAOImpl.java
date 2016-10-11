package winder.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import winder.vo.MembersVO;

@Repository("membersDAO")
public class MembersDAOImpl implements MembersDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertMembers(MembersVO members) throws RuntimeException {
		return sqlSession.insert("winder.Members.insertMembers", members);
	}

	@Override
	public int deleteMembers(int mno) {
		return sqlSession.delete("winder.Members.deleteMembers", mno);
	}

	@Override
	public int updateMembers(MembersVO members) {
		return sqlSession.update("winder.Members.updateMembers", members);
	}

	@Override
	public MembersVO selectMembers(int mno) {
		return sqlSession.selectOne("winder.Members.selectMembers",mno);
	}

	@Override
	public List<MembersVO> selectAllMembers() {
		List<MembersVO> selectAllMembers =new ArrayList<>();
		selectAllMembers=sqlSession.selectList("winder.Members.selectAllMembers");
		return selectAllMembers;
	}

	@Override
	public List<MembersVO> teamMember(String pno) {
		return sqlSession.selectList("winder.Members.teamMember", pno);
	}

	@Override
	public MembersVO selectMembersTno(String id) {
		return sqlSession.selectOne("winder.Members.selectMembersTno", id);
	}

	@Override
	public MembersVO selectMembersPosition(MembersVO members) {
		return sqlSession.selectOne("winder.Members.selectMembersPosition", members);
	}

	@Override
	public List<MembersVO> selectAllMembersTno(int tno) {
		return sqlSession.selectList("winder.Members.selectAllMembersTno",tno);
	}

	@Override
	public int deleteMembersTeamOut(MembersVO members) {
		return sqlSession.delete("winder.Members.deleteMembersTeamOut", members);
	}
	
	@Override
	public List<MembersVO> selectTeamMember(int tno) {
		return sqlSession.selectList("winder.Members.selectTeamMember", tno);
	}
	
/*	public List selectList(String queryId, Object params){
		return sqlSession.selectList(queryId,params);
	}
	
	@Override
	public List<Map<String,Object>> selectTeamMember(int tno) {
		return (List<Map<String, Object>>)selectList("winder.Members.selectTeamMember", tno);
	}*/
	
	
}
