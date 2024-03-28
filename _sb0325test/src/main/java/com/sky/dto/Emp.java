package com.sky.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private Integer mgr;
	private String hiredate;
	private int sal;
//	private int comm;
	private Integer comm;
	private int deptno;
}
