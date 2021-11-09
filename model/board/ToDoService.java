package model.board;

import java.util.List;

public interface ToDoService {
	void insertTodo(ToDoVO vo);
	void deleteTodo(ToDoVO vo);
	void updateTodo(ToDoVO vo);
	ToDoVO getDBDate(ToDoVO vo);
	List<ToDoVO> getDBList(ToDoVO vo);

}
