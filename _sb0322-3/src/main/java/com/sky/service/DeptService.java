package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.DeptDao;
import com.sky.dto.Dept;

@Service
public class DeptService {

	@Autowired
	private DeptDao deptDao;
	
	public List<Dept> printList(){
		return deptDao.deptList();
	}
}
