package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sky.service.Service;





@Controller
public class AjaxController { //이름의미x  //컨트롤러 두개 이상있어도 되지만, 같은거 x
	
	@GetMapping("/ajax1")
	public String ajax1() {
		return "ajax1";
	}
	
	@Autowired
	private Service service;

	@GetMapping("list")
	public String list(Model model) {
		model.addAttribute("list",Service.selectDeptList());
		model.addAttribute("list",Service.selectEmpList());
		return "list";
	}
//	
	@GetMapping("/employees")
	public ResponseEntity<List<Emp>> getEmployeesByDeptno(@RequestParam int deptno) {
	    List<Emp> employees = empService.findByDeptno(deptno); // empService는 empDao.selectByDeptno를 호출합니다
	    return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/getEmpnosByDeptno")
	@ResponseBody
	public List<Integer> getEmpnosByDeptno(@RequestParam int deptno) {
	    // 부서 번호에 따라 사원 번호를 조회하는 서비스 메서드를 호출
	    return employeeService.getEmpnosByDeptno(deptno);
	}

	// 사원 번호에 따른 사원 상세 정보 반환
	@GetMapping("/getEmpDetailsByEmpno")
	@ResponseBody
	public Employee getEmpDetailsByEmpno(@RequestParam int empno) {
	    // 사원 번호에 따라 사원 상세 정보를 조회하는 서비스 메서드를 호출
	    return employeeService.getEmpDetailsByEmpno(empno);
	}
	// 컨트롤러에서의 사용 예
	@GetMapping("/dept/{deptno}/employees")
	public ResponseEntity<List<Integer>> getEmployeesByDeptno(@PathVariable int deptno) {
	    List<Integer> empnos = deptDao.findEmpnosByDeptno(deptno);
	    return ResponseEntity.ok(empnos);
	}

	@GetMapping("/emp/{empno}/details")
	public ResponseEntity<Emp> getEmpDetailsByEmpno(@PathVariable int empno) {
	    Emp empDetails = empDao.findEmpDetailsByEmpno(empno);
	    if (empDetails == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(empDetails);
	}
	
	
	
}
