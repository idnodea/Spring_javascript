package com.sky.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.sky.dto.EmpOrigin;



@Repository
public class EmpDaoOrigin {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
//	public List<Emp> findByDeptno(int deptno) {
//	    return jdbcTemplate.query(
//	        "SELECT * FROM EMP WHERE DEPTNO = ?",
//	        new Object[]{deptno},
//	        (rs, rowNum) -> new Emp(
//	            rs.getInt("empno"),
//	            rs.getString("ename"),
//	            rs.getString("job"),
//	            rs.getInt("mgr"),
//	            rs.getDate("hiredate"),
//	            rs.getInt("sal"),
//	            rs.getInt("comm"),
//	            rs.getInt("deptno")
//	        )
//	    );
//	}
	
	//사원번호를 통한 검색및 조회
		public EmpOrigin selectByEmpno(int empno) {
		    List<EmpOrigin> results = jdbcTemplate.query(
		        "SELECT * FROM EMP WHERE EMPNO = ?", 
		       
		        (rs, rowNum) ->{return new EmpOrigin(
		            rs.getInt("empno"), 
		            rs.getString("ename"), 
		            rs.getString("job"),
		            rs.getInt("mgr"), 
		            rs.getString("hiredate"), 
		            rs.getInt("sal"), 
		            rs.getInt("comm"), 
		            rs.getInt("deptno")
		        );}, empno
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
		public void insert(EmpOrigin emp) {
		    KeyHolder keyHolder = new GeneratedKeyHolder();
		    jdbcTemplate.update(connection -> {
		        PreparedStatement ps = connection.prepareStatement(
		                "INSERT INTO EMP (ENAME, JOB, MGR, HIREDATE, SAL,COMM,DEPTNO) VALUES (?, ?, ?, ?, ?,?,?)",
		                Statement.RETURN_GENERATED_KEYS);
//		        ps.setInt(1, emp.getEmpno());
		        ps.setString(1, emp.getEname()); 
		        ps.setString(2, emp.getJob()); 
		        ps.setInt(3, emp.getMgr());
		        ps.setString(4, emp.getHiredate()); 
		        ps.setInt(5, emp.getSal());
		        ps.setInt(6, emp.getComm());
//		        ps.setInt(7, emp.getDeptno());
		        return ps;
		    }, keyHolder);

//		     생성된 키(예: memberno)를 member 객체에 설정합니다. 이는 보통 auto-increment 필드에 대해 사용됩니다.
		     emp.setEmpno(keyHolder.getKey().intValue()); // 만약 empno가 필요한 경우에만 사용
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
		public void update(EmpOrigin emp) {
			jdbcTemplate.update("UPDATE emp SET ENAME=?, JOB=?, MGR=?, HIREDATE=?, SAL=?,COMM=?,DEPTNO=? WHERE MEMBERNO = ?",
					emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDeptno()
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
		public List<EmpOrigin> selectAll() {
			return jdbcTemplate.query("SELECT * FROM EMP",
					(rs, rowNum) -> new EmpOrigin(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"),
							rs.getInt("mgr"), rs.getString("hiredate"), rs.getInt("sal"),
							rs.getInt("comm"),rs.getInt("deptno")
							));
		}
		
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
			public void delete(int empno) {
				jdbcTemplate.update("delete from emp where empno = ?", empno);
			}
		
		@SuppressWarnings("null")
		public int count() {
			return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM emp", Integer.class);
		}
		
		
		

//	    // empno를 이용해 특정 사원의 deptno 부서번호를 조회합니다.
//	    public String findEmpnoByDeptno(int empno) {
//	        return jdbcTemplate.queryForObject("SELECT deptno FROM emp WHERE empno = ?", 
//	                                           new Object[]{empno}, String.class);
//	    }
		
		public List<EmpOrigin> findByDeptno(int deptno) {
		    // SQL 쿼리를 실행하여 해당 부서번호의 모든 사원을 리스트로 반환합니다.
		    return jdbcTemplate.query(
		        "SELECT * FROM emp WHERE deptno = ?",
		        new Object[]{deptno},
		        (rs, rowNum) -> new EmpOrigin(
		            // 여기에 Emp 생성자에 맞는 파라미터를 넣습니다.
		        )
		    );
		}
}
