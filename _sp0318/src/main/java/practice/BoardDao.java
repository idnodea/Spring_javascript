package practice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BoardDao {
	
   private JdbcTemplate jdbcTemplate;

   public BoardDao(DataSource dataSource) {
	   this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   public int count() {
       Integer count = jdbcTemplate
       		.queryForObject("select count(*) from board",
       				                        Integer.class);
       return count;
    }
    
//    public String memberName(int memberno) {
//    	return jdbcTemplate		
//    	 .queryForObject(
//    			 "select name from member where memberno = ?",
//    			 String.class, memberno);
//    }
   public String BoardName(int num) {
	   return jdbcTemplate.queryForObject("select num from board where memberno = ?", String.class, num);
   }
   
   
//    public void insert(Member member) {
//    	jdbcTemplate.update(
//    	   "insert into member(id, pw, name) values(?,?,?)",
//    	   member.getId(), member.getPw(), member.getName());
//    }
   public void insert(Board board) {
	   jdbcTemplate.update("insert into board(writer, title, content, regtime, hits, memberno) values(?,?,?,?,?,?)",
			   board.getWriter(),board.getTitle(),board.getContent(),board.getRegtime(),board.getHits(),board.getMemberno());
			  
   }
//	 writer, title,content, regtime,hits, memberno;
   
   
//    public void update(Member member) {
//    	jdbcTemplate.update(
//    	   "update member set pw = ?, name = ? where memberno = ?",
//    	   member.getPw(), member.getName(), member.getMemberno());
//    }
   public void update(Board board) {
	   jdbcTemplate.update("update board set writer=?, title=?, content=?, regtime=?, hits=?, memberno=? where num=?",
			   board.getWriter(),board.getTitle(),board.getContent(),board.getRegtime(),board.getHits(),board.getMemberno());
   }
   
   
//    public void delete(int memberno) {
//    	jdbcTemplate.update("delete from member where memberno = ?",
//    			            memberno);
//    }
   public void delete(int num) {
	   jdbcTemplate.update("delete from board where num=?",num);
   }
   
   
//    public List<Member> selectAll() {
//    	List<Member> results = jdbcTemplate.query("select * from member",
//    			new RowMapper<Member>() {  //익명의 개체생성
//
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						Member dto = new Member(
//								rs.getInt("memberno"),
//								rs.getString("id"),
//								rs.getString("pw"),
//								rs.getString("name")
//								);
//						return dto;
//					}
//    		
//    	});
//    	return results;
//    }
   public List<Board> selectAll(){
	   List<Board> results = jdbcTemplate.query("select * from board",
			   new RowMapper<Board>() {
		   
		   @Override
		   public Board mapRow(ResultSet rs, int rowNum) throws SQLException{
			   Board boardDto = new Board(
					   
					   rs.getInt("num"),
					   rs.getString("writer"),
					   rs.getString("title"),
					   rs.getString("content"),
					   rs.getString("regtime"),
					   rs.getInt("hits"),
					   rs.getInt("memberno")
					   );
			   return boardDto;
		   }
	   }
			   
			   ); //익명의 개체생성  생성은 로우맵퍼가 해줄것
	   
	   return results;
   }
   
   
//    public List<Member> selectAll2() {
//    	List<Member> results = jdbcTemplate.query("select * from member",
//    			(rs, n)->{
//			          Member dto = new Member(
//					         rs.getInt("memberno"),
//					         rs.getString("id"),
//					         rs.getString("pw"),
//					         rs.getString("name")
//					  );
//			          return dto;
//		        });
//    	return results;
//    }
   public List<Board> selectAll2() {
		List<Board> results = jdbcTemplate.query("select * from board", (rs, n) -> {
			Board dto = new Board(
						rs.getInt("num"),
					   rs.getString("writer"),
					   rs.getString("title"),
					   rs.getString("content"),
					   rs.getString("regtime"),
					   rs.getInt("hits"),
					   rs.getInt("memberno"));
			return dto;
		});
		return results;
	}
   
}