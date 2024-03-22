package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sky.dao.DeptDao;
import com.sky.dao.EmpDao;
import com.sky.dto.Dept;
import com.sky.dto.Emp;


@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private EmpDao empDao;
	
	//복수 검색
	
	//신규
	public void insertE(Emp emp) {
		empDao.insert(emp);
	}
	public void insertD(Dept dept) {
		deptDao.insert(dept);
	}
	//수정
	public void updateE(Emp emp) {
		empDao.update(emp);
	}
	public void updateD(Dept dept) {
		deptDao.update(dept);
	}
	//삭제
	public void deleteE(int empno) {
		empDao.delete(empno);
	}
	public void deleteD(int deptno) {
		deptDao.delete(deptno);
	}
	//특정검색
	public List<Emp> selectEmpList() {
		return empDao.selectAll();
	}
	public List<Dept> selectDeptList() {
		return deptDao.selectAll();
	}
//	public List<Dept> selList() {
//		return deptDao.selectAll();
//	}
	
	
	// empno를 이용해 특정 사원의 deptno를 조회합니다.
	public Emp findEmpnoByDeptno(int empno) {
		return empDao.selectByEmpno(empno);
	}
	
	 // empno를 이용해 특정 사원의 deptno를 조회합니다.
//	public Dept findEmpnoByDeptno(int deptno) {
//		return deptDao.selectBydeptno(deptno);
//	}

}
