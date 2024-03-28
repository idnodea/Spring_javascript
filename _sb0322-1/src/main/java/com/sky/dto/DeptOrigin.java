package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
//@AllArgsConstructor
public class DeptOrigin {
	
	
	
	private int deptno;
	private String dname;
	private String loc;
	
	public DeptOrigin() {
		
	}
	
	public DeptOrigin(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	
}


