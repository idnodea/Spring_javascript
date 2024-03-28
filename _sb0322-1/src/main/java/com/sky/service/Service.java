//package com.sky.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.sky.dao.DeptDao;
//import com.sky.dao.EmpDao;
//import com.sky.dto.Dept;
//import com.sky.dto.Emp;
//
//
//@org.springframework.stereotype.Service
//public class Service {
//
//	@Autowired
//	private DeptDao deptDao;
//	
//	@Autowired
//	private EmpDao empDao;
//	
//	//복수 검색
//	
//	//신규
//	public void insertE(Emp emp) {
//		empDao.insert(emp);
//	}
////	public void insertD(Dept dept) {
////		deptDao.insert(dept);
////	}
//	//수정
//	public void updateE(Emp emp) {
//		empDao.update(emp);
//	}
////	public void updateD(Dept dept) {
////		deptDao.update(dept);
////	}
//	//삭제
//	public void deleteE(int empno) {
//		empDao.delete(empno);
//	}
////	public void deleteD(int deptno) {
////		deptDao.delete(deptno);
////	}
//	//검색
//	public List<Emp> selectEmpList() {
//		return empDao.selectAll();
//	}
//	
//	public Dept selectByDeptno(int deptno) {
//		return deptDao.selectByDeptno(deptno);
//	}
//
//	
//	
////	public List<Dept> selectDeptList() {
////		return deptDao.selectAll();
////	}
////	public List<Dept> selList() {
////		return deptDao.selectAll();
////	}
//	
// 
////	// deptno를 이용해 특정 사원의 empno(사원번호)를 조회합니다.
////    public String findEmpnoByDeptno(int empno) {
////		return empDao.selectByEmpno(empno);
////	}
////	
////	 // empno를 이용해 특정 부서의 deptno(부서번호)를 조회합니다.
////    public String findDeptnoByEmpno(int deptno) { 
////		return deptDao.selectBydeptno(deptno);
////	}
//	
//	
//	public List<Emp> findEmployeesByDepartmentNumber(int deptno) {
//	    return empDao.findByDeptno(deptno);
//	}
////
////	public Dept findDepartmentByNumber(int deptno) {
////	    return deptDao.selectByDeptno(deptno);
////	}
//	
//}