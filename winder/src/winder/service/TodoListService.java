package winder.service;

import java.util.List;

import winder.vo.TodoJoinVO;
import winder.vo.TodoListVO;

public interface TodoListService {
	public int insertTodoList(TodoListVO todoList) throws RuntimeException;
	public int deleteTodoList(int tlno);
	public int updateTodoList(TodoListVO todoList);
	public List<TodoJoinVO> selectTodoList(int pno);
	public List<TodoListVO> selectAllTodoList();
	public TodoJoinVO selectSubtitle(int tlno) throws RuntimeException;
	public int statedone(String tlno) throws RuntimeException;
	public int statetodo(String tlno) throws RuntimeException;
}
