package com.sky.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.sky.dto.Emp;

@Repository
public class EmpDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Emp> empList(int deptno){
		List<Emp> list = new ArrayList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from emp where deptno=?",deptno);
		while(rs.next()) {
			Emp emp = Emp.builder()
					.empno(rs.getInt("empno"))
					.ename(rs.getString("ename"))
					.job(rs.getString("job"))
					.mgr(rs.getInt("mgr"))
					.hiredate(rs.getString("hiredate"))
					.sal(rs.getInt("sal"))
					.comm(rs.getInt("comm"))
					.deptno(rs.getInt("deptno")).build();
			list.add(emp);
		}
		return list;
	}
	
	public Emp selectOne(int empno) {
		List<Emp> results = jdbcTemplate.query("select * from emp where empno=?",
				new RowMapper<Emp>() {

					@Override
					public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
						Emp emp = Emp.builder()
								.empno(rs.getInt("empno"))
								.ename(rs.getString("ename"))
								.job(rs.getString("job"))
								.mgr(rs.getInt("mgr"))
								.hiredate(rs.getString("hiredate"))
								.sal(rs.getInt("sal"))
								.comm(rs.getInt("comm"))
								.deptno(rs.getInt("deptno")).build();
						return emp;
					}
		},empno);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void updateOne(Emp emp) {
		String sql = "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
		jdbcTemplate.update(sql,
				emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), 
				emp.getSal(), emp.getComm(), emp.getDeptno(),emp.getEmpno());
	}
}





