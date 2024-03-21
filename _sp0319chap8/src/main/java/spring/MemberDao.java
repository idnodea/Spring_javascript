
package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email);

		return results.isEmpty() ? null : results.get(0);
//		return results.isEmpty() ? new Member("없다", null, null, null) : results.get(0);
	}
	public Member selectByEmail2(String email) {
		Member results = jdbcTemplate.queryForObject(///반드시 실행결과1행일때  값이 반드시 하나. 
				"select * from MEMBER where EMAIL = ?", //null이 아닌 Exception
				new RowMapper<Member>() {//인터페이스,생성자x,재정의o
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email);

		return results;
//		return results.isEmpty() ? new Member("없다", null, null, null) : results.get(0);
	}
	public Member selectByEmail3(String email) {  //1 을 람다식으
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where EMAIL = ?",
				(rs,rowNum)->{
//				new RowMapper<Member>() {
//					@Override
//					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//						{
							Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
//					}
				}, email);
		
		return results.isEmpty() ? null : results.get(0);
//		return results.isEmpty() ? new Member("없다", null, null, null) : results.get(0);
	}
	
	// 이건 굳이?
	public void insert(Member member) { //여기서 키홀더를 추가하여 리턴값을 받아올 필요가 있을 때
		
		//변경해보자
		KeyHolder keyHolder = new GeneratedKeyHolder();  //키홀더추가
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt 
					= con.prepareStatement(
							"insert into member(EMAIL,PASSWORD,NAME,REGDATE) values (?,?,?,now())",
							new String[] {"ID"} );//여기서 id는 필드명임.  추가
						
				pstmt.setString(1, member.getEmail());
				pstmt.setString(1, member.getPassword());
				pstmt.setString(1, member.getName());
				return pstmt;
			}
		}, keyHolder );  //키홀더 추가
		Number keyValue = keyHolder.getKey(); //키홀더 추가 후 2줄.
		member.setId(keyValue.longValue()); //멤버에 넣어주는.
	}
	
	public void insert2(Member member) {  //이걸로는 리턴값을 받아오지 못하므로
			jdbcTemplate.update(
					"insert into member(EMAIL,PASSWORD,NAME,REGDATE) values (?,?,?,now())",
					member.getEmail(),member.getPassword(),member.getName());
	}

	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME =?,PASSWORD=?, where EMAIL=?",
				member.getName(),member.getPassword(),member.getEmail()
				
				);
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query(
//				"select * from MEMBER where EMAIL = ?",
				"select * from MEMBER",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
					}
				});

		return results;
	}
	
	public int count() {
//		Integer count = jdbcTemplate.queryForObject(
//				"select count(*) from member", Integer.class);
//		return count;
		return  jdbcTemplate.queryForObject(
				"select count(*) from member", Integer.class);  //0이라도 나오는,결과값이 무조건 있다.
		
	}
	
}
//package spring;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class MemberDao {
//
//	private static long nextId = 0;
//
////	private Map<String, Member> map = new HashMap<>();
//
//	public Member selectByEmail(String email) {
////		return map.get(email);
//		return null;
//	}
//
//	public void insert(Member member) {
////		member.setId(++nextId);
////		map.put(member.getEmail(), member);
//	}
//
//	public void update(Member member) {
////		map.put(member.getEmail(), member);
//	}
//
//	public Collection<Member> selectAll() {
////		return map.values();
//		return null;
//	}
//}
