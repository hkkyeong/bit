package winder.dao;

import java.util.List;
import winder.vo.TeamVO;

public interface TeamDAO {
	
	public int insertTeam(TeamVO team) throws RuntimeException;
	public int deleteTeam(int tno);
	public int updateTeam(TeamVO team);
	public TeamVO selectTeam(int tno);
	public List<TeamVO> selectAllTeam();
	public List<TeamVO> selectTeamList(String id) throws RuntimeException;
	public TeamVO selectTeamName(int tno);

}
