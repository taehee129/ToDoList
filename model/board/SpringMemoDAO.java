package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class MemoRowMapper implements RowMapper<MemoVO>{

	@Override
	public MemoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MemoVO memo = new MemoVO();
		memo.setContent(rs.getString("content"));
		memo.setId(rs.getInt("id"));
		memo.setParentId(rs.getInt("parentId"));
		memo.setTitle(rs.getString("title"));
		
		
		return memo;
	}
	
	
	
}

class GetMaxIdMapper implements RowMapper<Integer>{

	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return 	rs.getInt(1);
	}

}


@Repository
public class SpringMemoDAO {
	private String insertSQL ="insert into memo(id,title,content,parentId) values((select nvl(max(id),0)+1 from memo),?,?,?)";
	private String updateSQL= "update memo set title=?, content=? where id=?";
	private String deleteSQL = "delete from memo where id=?";
	private String getDBDate = "select * from memo where id=?";
	private String getDBList= "select * from memo where parentId=?";
	private String getMaxId = "select nvl(max(id),0)+1 from memo";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertMemo(MemoVO vo) {
		Object[] args = {vo.getTitle(),vo.getContent(),vo.getParentId()};
		int maxId = jdbcTemplate.queryForObject(getMaxId, new GetMaxIdMapper());
		System.out.println("insertMemo() MaxId : "+maxId);
		jdbcTemplate.update(insertSQL, args);
		
		return maxId;
		
	}
	public void updateMemo(MemoVO vo) {
		Object[] args = {vo.getTitle(), vo.getContent(), vo.getId()};
		jdbcTemplate.update(updateSQL,args);
	}
	public void deleteMemo(MemoVO vo) {
		System.out.println(vo + " ªË¡¶ ¡ﬂ!");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
	public MemoVO getDBDate(MemoVO vo) {
		Object[] args = {vo.getId()};
		return  jdbcTemplate.queryForObject(getDBDate, args, new MemoRowMapper());
	}
	public List<MemoVO> getDBList(MemoVO vo){
		Object[] args = {vo.getParentId()};
		return jdbcTemplate.query(getDBList, args, new MemoRowMapper());
	}
	
	

}
