package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.TodoListDAO;
import winder.vo.TodoJoinVO;
import winder.vo.TodoListVO;

@Service
public class TodoListServiceImpl implements TodoListService{
	
	@Autowired
	private TodoListDAO todolistDAO;

	@Override
	public int insertTodoList(TodoListVO todoList) throws RuntimeException {
		return todolistDAO.insertTodoList(todoList);
	}

	@Override
	public int deleteTodoList(int tlno) {
		return todolistDAO.deleteTodoList(tlno);
	}

	@Override
	public int updateTodoList(TodoListVO todoList) {
		return todolistDAO.updateTodoList(todoList);
	}

	@Override
	public List<TodoJoinVO> selectTodoList(int pno) {
		return todolistDAO.selectTodoList(pno);
	}

	@Override
	public List<TodoListVO> selectAllTodoList() {
		return todolistDAO.selectAllTodoList();
	}

	@Override
	public TodoJoinVO selectSubtitle(int tlno) throws RuntimeException {
		return todolistDAO.selectSubtitle(tlno);
	}

	@Override
	public int statedone(String tlno) throws RuntimeException {
		return todolistDAO.statedone(tlno);
	}

	@Override
	public int statetodo(String tlno) throws RuntimeException {
		return todolistDAO.statetodo(tlno);
	}

	@Override
	public List<TodoJoinVO> selectTdDate(int pno) {
		return todolistDAO.selectTdDate(pno);
	}

	@Override
	public List<TodoListVO> dateCheck(String id) {
		return todolistDAO.dateCheck(id);
	}

	@Override
	public int countCheck(int tlno) throws RuntimeException {
		return todolistDAO.countCheck(tlno);
	}

	@Override
	public int insertCheck(TodoListVO todolist) throws RuntimeException {
		return todolistDAO.insertCheck(todolist);
	}
	

}
