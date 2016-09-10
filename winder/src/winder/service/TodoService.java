package winder.service;

import java.util.List;
import winder.vo.TodoVO;

public interface TodoService {
	public int insertTodo(TodoVO todo) throws RuntimeException;
	public int deleteTodo(int tdno);
	public int updateTodo(TodoVO todo);
	public TodoVO selectTodo(int tdno);
	public List<TodoVO> selectAllTodo();
	public List<TodoVO> listTodo(int pno) throws RuntimeException;
}
