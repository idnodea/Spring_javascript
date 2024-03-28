package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.EmpDao;
import com.sky.dto.Emp;

@Service
public class EmpService {

	@Autowired
	private EmpDao empDao;
	
	public List<Emp> printList(int deptno){
		return empDao.empList(deptno);
	}
	
	public Emp selectOne(int empno) {
		return empDao.selectOne(empno);
	}
	public void updateOne(Emp emp) {
		empDao.updateOne(emp);
	}
}
