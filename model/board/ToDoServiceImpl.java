package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("toDoService")
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	SpringToDoListDAO toDoListDAO;
	
	
	@Override
	public void insertTodo(ToDoVO vo) {
		// TODO Auto-generated method stub
		toDoListDAO.insertToDo(vo);
		
	}

	@Override
	public void deleteTodo(ToDoVO vo) {
		// TODO Auto-generated method stub
		toDoListDAO.deleteToDo(vo);
		
	}

	@Override
	public void updateTodo(ToDoVO vo) {
		// TODO Auto-generated method stub
		toDoListDAO.updateToDo(vo);
		
	}

	@Override
	public ToDoVO getDBDate(ToDoVO vo) {
		// TODO Auto-generated method stub
		return toDoListDAO.getDBDate(vo);
		
	}

	@Override
	public List<ToDoVO> getDBList(ToDoVO vo) {
		// TODO Auto-generated method stub
		
		return toDoListDAO.getDBList(vo);
	}

}
