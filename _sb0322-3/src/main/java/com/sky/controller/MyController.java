package com.sky.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.State;
import com.sky.dto.Dept;
import com.sky.dto.Emp;
import com.sky.service.DeptService;
import com.sky.service.EmpService;

@Controller
public class MyController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private EmpService empService;
	@Autowired
	private State state;

	@GetMapping("/")
	public String root(Model model) {
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		return "root";
	}

	@GetMapping("/ajax")
	public String rootWithAjax(Model model) {
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		return "rootWithAjax";
	}
	
	@GetMapping("/selectEmp")
	public String selectEmp(int deptno, Model model) {
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		state.setDeptno(deptno);
		System.out.println(deptno);
		List<Emp> empList = empService.printList(deptno);
		model.addAttribute("list2",empList);
		return "selectEmp";
	}
	
	@GetMapping("/updateForm")
	public String selectEmpOne(int empno, Model model) {
		int deptno = state.getDeptno();
		state.setEmpno(empno);
		System.out.println(deptno);
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		List<Emp> empList = empService.printList(deptno);
		model.addAttribute("list2",empList);
		Emp member = empService.selectOne(empno);
		model.addAttribute("member",member);
		System.out.println(member);
		return "updateForm";
	}
	@PostMapping("/input")
	public String updateMember(Emp emp, Model model) {
		empService.updateOne(emp);
		int empno = state.getEmpno();

		int deptno = state.getDeptno();
		state.setEmpno(empno);
		System.out.println(deptno);
		List<Dept> deptList = deptService.printList();
		model.addAttribute("list", deptList);
		List<Emp> empList = empService.printList(deptno);
		model.addAttribute("list2",empList);
		Emp member = empService.selectOne(empno);
		model.addAttribute("member",member);
		System.out.println(member);
		
		
		System.out.println("empno 값: "+empno);
		model.addAttribute(emp);
		System.out.println("나오나?"+emp.toString());
		empService.updateOne(emp);
		return "updateForm";
	}

}
