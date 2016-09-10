package winder.dao;

import java.util.List;
import winder.vo.ProjectVO;

public interface ProjectDAO {

	public int insertProject(ProjectVO project) throws RuntimeException;

	public int deleteProject(int pno);

	public int updateProject(ProjectVO project);

	public ProjectVO selectProject(int pno);

	public List<ProjectVO> selectProjectList(String tno);

	public List<ProjectVO> selectProjectMenu(String id) throws RuntimeException;

	// management권한을 위해 pno를 이용하여 tno를 구한다.
	public int selectProjectTno(int pno);
}
