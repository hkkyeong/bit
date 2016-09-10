package winder.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import winder.vo.TodoVO;

@Repository("todoDAO")
public class TodoDAOImpl implements TodoDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertTodo(TodoVO todo) throws RuntimeException {
		return sqlSession.insert("winder.Todo.insertTodo", todo);
	}

	@Override
	public int deleteTodo(int tdno) {
		return sqlSession.delete("winder.Todo.deleteTodo", tdno);
	}

	@Override
	public int updateTodo(TodoVO todo) {
		return sqlSession.update("winder.Todo.updateTodo", todo);
	}

	@Override
	public TodoVO selectTodo(int tdno) {
		return sqlSession.selectOne("winder.Todo.selectTodo",tdno);
	}

	@Override
	public List<TodoVO> selectAllTodo() {
		List<TodoVO> selectAllTodo =new ArrayList<>();
		selectAllTodo=sqlSession.selectList("winder.Todo.selectAllTodo");
		return selectAllTodo;
	}

	@Override
	public List<TodoVO> listTodo(int pno) throws RuntimeException {
		return sqlSession.selectList("winder.Todo.listTodo", pno);
	}
	

}
