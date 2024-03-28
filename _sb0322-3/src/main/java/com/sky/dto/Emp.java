package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Emp {

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hiredate;
	private int sal;
	private int comm;
	private int deptno;
	
	public Emp() {}

	public Emp(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		if(hiredate.length() >= 8) {
		this.hiredate = hiredate.substring(2,10);
		} else { this.hiredate = hiredate; }
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	
}
