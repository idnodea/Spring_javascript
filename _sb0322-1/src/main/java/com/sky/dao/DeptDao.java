package com.sky.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sky.dto.Dept;




@Repository
public class DeptDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	//부서번호를 통한 검색및 조회
		public Dept selectByEmpno(int deptno) {
		    List<Dept> results = jdbcTemplate.query(
		        "SELECT * FROM DEPT WHERE DEPTNO = ?", 
		       
		        (rs, rowNum) ->{return new Dept(
		            rs.getInt("deptno"), 
		            rs.getString("dname"), 
		            rs.getString("loc")
		           
		        );}, deptno
		    );
		    return results.isEmpty() ? null : results.get(0);
		}
		//멤버아이디를 통한 검색및 조회  람다식으로변경
//		public MemberDto selectById(String id) {
//		    List<MemberDto> results = jdbcTemplate.query(
//		        "SELECT * FROM MEMBER WHERE ID = ?", 
//		        
//		        (rs, rowNum) -> {return new MemberDto(
//		            rs.getInt("memberno"), 
//		            rs.getString("id"), 
//		            rs.getString("email"),
//		            rs.getInt("age"), 
//		            rs.getString("name"), 
//		            rs.getString("memo")
//		        );}, id
//		    );
	//
//		    return results.isEmpty() ? null : results.get(0);
//		}
		
		//멤버번호 람다식x
//		public MemberDto selectByMemberno(int Memberno) {
//		    List<MemberDto> results = jdbcTemplate.query(
//		        "SELECT * FROM MEMBER WHERE memberno = ?", 
//		        
//		        new RowMapper<MemberDto>() {
//		            @Override
//		            public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//		                MemberDto member = new MemberDto(
//		                    rs.getInt("memberno"),
//		                    rs.getString("id"),
//		                    rs.getString("email"),
//		                    rs.getInt("age"),
//		                    rs.getString("name"),
//		                    rs.getString("memo")
//		                );
//		                member.setMemberno(rs.getInt("memberno"));
//		                return member;
//		            }
//		        }, new Object[]{Memberno}
//		    );
//		    return results.isEmpty() ? null : results.get(0);
//		}
		
		
		//이메일x
//		public MemberDto selectByEmail(String email) {
//			List<MemberDto> results = jdbcTemplate.query("SELECT * FROM MEMBER WHERE EMAIL = ?", new Object[] { email },
//					(rs, rowNum) -> new MemberDto(rs.getInt("memberno"), rs.getString("id"), rs.getString("email"),
//							rs.getInt("age"), rs.getString("name"), rs.getString("memo")));
//			return results.isEmpty() ? null : results.get(0);
//		}
		
		//인서트
//		public void insert(MemberDto member) {
//		    jdbcTemplate.update(
//		        "INSERT INTO MEMBER ( EMAIL, ID, NAME, AGE,MEMO) VALUES ( ?, ?, ?, ?, ?)",
//		         member.getEmail(), member.getId(), member.getName(), member.getAge(),member.getMemo()
//		    );
//		}
		
		
		//인서트를 람다식으로 수정
		public void insert(Dept dept) {
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    jdbcTemplate.update(connection -> {
		        PreparedStatement ps = connection.prepareStatement(
		                "INSERT INTO DEPT (DNAME,LOC) VALUES (?, ?)",
		                Statement.RETURN_GENERATED_KEYS);
//		        ps.setInt(1, emp.getDeptno());
		        ps.setString(1, dept.getDname()); 
		        ps.setString(2, dept.getLoc()); 
		       
//		       
		        return ps;
		    }, keyHolder);

//		     생성된 키(예: memberno)를 member 객체에 설정합니다. 이는 보통 auto-increment 필드에 대해 사용됩니다.
		     dept.setDeptno(keyHolder.getKey().intValue()); // 만약 empno가 필요한 경우에만 사용
		}
		
		//인서트
//		public void insert(MemberDto member) {
//		    KeyHolder keyHolder = new GeneratedKeyHolder();
//		    jdbcTemplate.update(new PreparedStatementCreator() {
//		        @Override
//		        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
//		            PreparedStatement ps = connection.prepareStatement(
//		                "INSERT INTO MEMBER (EMAIL, ID, NAME, AGE, MEMO) VALUES (?, ?, ?, ?, ?)", 
//		                Statement.RETURN_GENERATED_KEYS);
//		            ps.setString(1, member.getEmail());
//		            ps.setString(2, member.getId());
//		            ps.setString(3, member.getName());
//		            ps.setInt(4, member.getAge());
//		            ps.setString(5, member.getMemo());
//		            return ps;
//		        }
//		    }, keyHolder);
	//
//		    // 생성된 키(예: memberno)를 member 객체에 설정할 수 있습니다.
//		    member.setMemberno(keyHolder.getKey().intValue());
//		}
		//업데이트
		public void update(Dept dept) {
			jdbcTemplate.update("UPDATE DEPT SET DNAME=?, LOC=? WHERE DEPTNO = ?",
					dept.getDname(),dept.getLoc()
					);
		}

		//원본
//		public List<MemberDto> selectAll() {
//			List<MemberDto> results = jdbcTemplate.query(
////					"select * from MEMBER where EMAIL = ?",
//					"select * from MEMBER",
//					new RowMapper<MemberDto>() {
//						@Override
//						public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//							MemberDto member = new MemberDto(
//									rs.getString("EMAIL"),
//									rs.getString("ID"),
//									rs.getString("NAME"),
////									rs.getTimestamp("REGDATE").toLocalDateTime());
//									rs.getInt("AGE"),
//									rs.getString("MEMO"),
//							member.setMemberno(rs.getInt("memberno"));
//							return member;
//						}
//					});
	//
//			return results;
//		}
		
		//람다식으로 셀렉트올 수정
		public List<Dept> selectAll() {
			return jdbcTemplate.query("SELECT * FROM DEPT",
					(rs, rowNum) -> 
			new Dept(rs.getInt("deptno"), rs.getString("dname"), rs.getString("loc"))
							
					
		);}
		
		//수정한 셀렉트올
//		public List<MemberDto> selectAll() {
//		    return jdbcTemplate.query("SELECT * FROM MEMBER", new RowMapper<MemberDto>() {
//		        @Override
//		        public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//		            MemberDto member = new MemberDto(
//		                rs.getInt("memberno"),
//		                rs.getString("id"),
//		                rs.getString("email"),
//		                rs.getInt("age"),
//		                rs.getString("name"),
//		                rs.getString("memo")
//		            );
//		            return member;
//		        }
//		    });
//		}
		
		//삭제
//		public void delete(String id) {
//			jdbcTemplate.update("delete from member where id = ?", id);
//		}
		//삭제2
			public void delete(int deptno) {
				jdbcTemplate.update("delete from dept where deptno = ?", deptno);
			}
		
		@SuppressWarnings("null")
		public int count() {
			return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM dept", Integer.class);
		}
		
		
		

		// (부서번호)deptno를 이용해 특정 사원의 empno(사원번호)를 조회합니다.
//	    public String findDeptnoByEmpno(int deptno) {
//	        return jdbcTemplate.queryForObject("SELECT empno FROM dept WHERE deptno = ?", 
//	                                           new Object[]{deptno}, String.class);
//	    }
}
