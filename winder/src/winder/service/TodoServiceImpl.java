package winder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import winder.dao.TodoDAO;
import winder.vo.TodoVO;

@Service("todoService")
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoDAO todoDAO;

	@Override
	public int insertTodo(TodoVO todo) throws RuntimeException {
		return todoDAO.insertTodo(todo);
	}

	@Override
	public int deleteTodo(int tdno) {
		return todoDAO.deleteTodo(tdno);
	}

	@Override
	public int updateTodo(TodoVO todo) {
		return todoDAO.updateTodo(todo);
	}

	@Override
	public TodoVO selectTodo(int tdno) {
		return todoDAO.selectTodo(tdno);
	}

	@Override
	public List<TodoVO> selectAllTodo() {
		return todoDAO.selectAllTodo();
	}

	@Override
	public List<TodoVO> listTodo(int pno) throws RuntimeException {
		return todoDAO.listTodo(pno);
	}

	

}
