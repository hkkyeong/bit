package winder.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import winder.vo.TodoJoinVO;
import winder.vo.TodoListVO;

@Repository("todoListDAO")
public class TodoListDAOImpl implements TodoListDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertTodoList(TodoListVO todoList) throws RuntimeException {
		return sqlSession.insert("winder.TodoList.insertTodoList", todoList);
	}

	@Override
	public int deleteTodoList(int tlno) {
		return sqlSession.delete("winder.TodoList.deleteTodoList", tlno);
	}

	@Override
	public int updateTodoList(TodoListVO todoList) {
		return sqlSession.update("winder.TodoList.updateTodoList", todoList);
	}

	@Override
	public List<TodoJoinVO> selectTodoList(int pno) {
		return sqlSession.selectList("winder.TodoList.selectTodoList", pno);
	}
	
	@Override
	public TodoJoinVO selectSubtitle(int tlno) throws RuntimeException {
		return sqlSession.selectOne("winder.TodoList.selectSubtitle", tlno);
	}

	@Override
	public int statedone(String tlno) throws RuntimeException {
		return sqlSession.update("winder.TodoList.statedone", tlno);
	}

	@Override
	public int statetodo(String tlno) throws RuntimeException {
		return sqlSession.update("winder.TodoList.statetodo", tlno);
	}

	@Override
	public List<TodoListVO> selectAllTodoList() {
		List<TodoListVO> selectAllTodoList =new ArrayList<>();
		selectAllTodoList=sqlSession.selectList("winder.TodoList.selectAllTodoList");
		return selectAllTodoList;
	}

	@Override
	public List<TodoJoinVO> selectTdDate(int pno) {
		return sqlSession.selectList("winder.TodoList.selectTdDate", pno);
	}

	@Override
	public List<TodoListVO> dateCheck(String id) {
		return sqlSession.selectList("winder.TodoList.dateCheck", id);
	}

	@Override
	public int countCheck(int tlno) throws RuntimeException {
		return sqlSession.selectOne("winder.DateCheck.countCheck", tlno);
	}

	@Override
	public int insertCheck(TodoListVO todolist) throws RuntimeException {
		return sqlSession.insert("winder.DateCheck.insertCheck", todolist);
	}

}
