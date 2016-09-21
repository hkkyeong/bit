package winder.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import winder.vo.TeamVO;

@Repository("teamDAO")
public class TeamDAOImpl implements TeamDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertTeam(TeamVO team) throws RuntimeException {
		return sqlSession.insert("winder.Team.insertTeam", team);
	}

	@Override
	public int deleteTeam(int tno) {
		return sqlSession.delete("winder.Team.deleteTeam", tno);
	}

	@Override
	public int updateTeam(TeamVO team) {
		return sqlSession.update("winder.Team.updateTeam", team);
	}

	@Override
	public TeamVO selectTeam(int tno) {
		return sqlSession.selectOne("winder.Team.selectTeam",tno);
	}

	@Override
	public List<TeamVO> selectAllTeam() {
		List<TeamVO> selectAllTeam =new ArrayList<>();
		selectAllTeam=sqlSession.selectList("winder.Team.selectAllTeam");
		return selectAllTeam;
	}

	@Override
	public List<TeamVO> selectTeamList(String id) throws RuntimeException {
		return sqlSession.selectList("winder.Team.selectTeamList", id);
	}

	@Override
	public TeamVO selectTeamName(int tno) {
		return sqlSession.selectOne("winder.Team.selectTeamName", tno);
	}
	public TeamVO selectTno(String code){
		return sqlSession.selectOne("winder.Team.selectTno",code);
	}
}
