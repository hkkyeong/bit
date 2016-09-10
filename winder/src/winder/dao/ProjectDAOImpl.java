package winder.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import winder.vo.ProjectVO;

@Repository("projectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertProject(ProjectVO project) throws RuntimeException {
		return sqlSession.insert("winder.Project.insertProject", project);
	}

	@Override
	public int deleteProject(int pno) {
		return sqlSession.delete("winder.Project.deleteProject", pno);
	}

	@Override
	public int updateProject(ProjectVO project) {
		return sqlSession.update("winder.Project.updateProject", project);
	}

	@Override
	public ProjectVO selectProject(int pno) {
		return sqlSession.selectOne("winder.Project.selectProject",pno);
	}

	@Override
	public List<ProjectVO> selectProjectList(String tno) {
		List<ProjectVO> selectAllProject =new ArrayList<>();
		selectAllProject=sqlSession.selectList("winder.Project.selectProjectList", tno);
		return selectAllProject;
	}

	@Override
	public List<ProjectVO> selectProjectMenu(String id) throws RuntimeException {
		return sqlSession.selectList("winder.Project.selectProjectMenu", id);
	}

	@Override
	public int selectProjectTno(int pno) {
		return sqlSession.selectOne("winder.Project.selectProjectTno", pno);
	}
	

}
