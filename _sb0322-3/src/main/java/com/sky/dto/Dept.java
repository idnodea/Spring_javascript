package com.sky.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Dept {

	private int deptno;
	private String dname;
	private String loc;
}
