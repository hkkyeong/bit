package winder.service;

import java.util.List;
import winder.vo.ProjectVO;

public interface ProjectService {

	public int insertProject(ProjectVO project) throws RuntimeException;
	public int deleteProject(int pno);
	public int updateProject(ProjectVO project);
	public ProjectVO selectProject(int pno);
	public List<ProjectVO> selectProjectList(String tno);
	public List<ProjectVO> selectProjectMenu(String id) throws RuntimeException;
}
