package com.sky;

import org.springframework.stereotype.Component;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class State {

	private int deptno;
	private int empno;
}
