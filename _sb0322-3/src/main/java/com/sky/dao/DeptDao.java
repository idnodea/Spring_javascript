package com.sky.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.sky.dto.Dept;

@Repository
public class DeptDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int count() {
		return jdbcTemplate.queryForObject("select count(*) from dept", Integer.class);
	}
	
	public List<Dept> deptList(){
		List<Dept> list = new ArrayList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from dept");
		while(rs.next()) {
			Dept dept = Dept.builder()
					.deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc")).build();
			list.add(dept);
		}
		return list;
	}
}
