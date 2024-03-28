package com.sky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sky.dto.Emp;

@Mapper
public interface EmpMapper {
	List<Emp> selectEmpList();
	
	int empCount();
	
	void insertEmp(Emp emp);   //sql-board.xml 이름과 같아야함

//	BoardDto selectBoardDetail(int boardIdx);
//
//	void updateHitCount(int boardIdx);
//	
	void updateEmp(Emp emp);
	
	void deleteEmp(int empno);  //매개변수값은 상관없
}
