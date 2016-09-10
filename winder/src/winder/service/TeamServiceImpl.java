package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.TeamDAO;
import winder.vo.TeamVO;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamDAO teamDAO;

	@Override
	public int insertTeam(TeamVO team) throws RuntimeException {
		return teamDAO.insertTeam(team);
	}

	@Override
	public int deleteTeam(int tno) {
		return teamDAO.deleteTeam(tno);
	}

	@Override
	public int updateTeam(TeamVO team) {
		return teamDAO.updateTeam(team);
	}

	@Override
	public TeamVO selectTeam(int tno) {
		return teamDAO.selectTeam(tno);
	}

	@Override
	public List<TeamVO> selectAllTeam() {
		return teamDAO.selectAllTeam();
	}

	@Override
	public List<TeamVO> selectTeamList(String id) throws RuntimeException {
		return teamDAO.selectTeamList(id);
	}

	@Override
	public TeamVO selectTeamName(int tno) {
		return teamDAO.selectTeamName(tno);
	}
	

}
