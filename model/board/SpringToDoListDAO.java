package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class ToDoRowMapper implements RowMapper<ToDoVO>{

	@Override
	public ToDoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ToDoVO toDo = new ToDoVO();
		toDo.setDeadline(rs.getDate("deadline"));
		toDo.setId(rs.getInt("id"));
		toDo.setImportance(rs.getInt("importance"));
		toDo.setProgress(rs.getInt("progress"));
		toDo.setName(rs.getString("name"));
		toDo.setWriter(rs.getString("writer"));
		
		return toDo;
	}
	
		
}
		
	
	


@Repository
public class SpringToDoListDAO {
	
	private final String insertSQL ="insert into todolist(id,name,progress,deadline,importance,writer) values((select nvl(max(id),0)+1 from todoList),?, ?,?,?,?)"; 
	private final String deleteSQL="delete from todolist where id=?";
	private final String updateSQL = "update todolist set name=?, progress=?, deadline=?, importance=? where id=?";
	private final String getDBDate = "select * from todolist where id=?";
	private final String getDBList = "select * from todolist where writer=?";
	
	
	private JdbcTemplate jdbcTemplate;


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	} 
	
	public void insertToDo(ToDoVO vo) {
		
		Object[] args = {vo.getName(),vo.getProgress(), vo.getDeadline(), vo.getImportance(),vo.getWriter()};
		jdbcTemplate.update(insertSQL,args);
	}
	public void deleteToDo(ToDoVO vo) {
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
	public void updateToDo(ToDoVO vo) {
		Object[] args = {vo.getName(),vo.getProgress(), vo.getDeadline(), vo.getImportance(),vo.getId()};
		jdbcTemplate.update(updateSQL, args );
	}
	
	public ToDoVO getDBDate(ToDoVO vo) {
		
		Object[] args = {vo.getId()};
		return jdbcTemplate.queryForObject(getDBDate,args,  new ToDoRowMapper());
	}
	
	public List<ToDoVO> getDBList(ToDoVO vo) {
		String[] args = {vo.getWriter()};
		
		return jdbcTemplate.query(getDBList, args, new ToDoRowMapper());
	}
	

}
