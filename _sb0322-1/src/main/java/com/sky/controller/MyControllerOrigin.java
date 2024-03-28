//package com.sky.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.sky.dto.DeptOrigin;
//import com.sky.dto.EmpOrigin;
//import com.sky.service.Service;
//
//@Controller
//public class MyControllerOrigin {
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//	
//	@GetMapping("/")
//	public String root(Model model) {
//		List<DeptOrigin> list = new ArrayList<>();
//		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from dept");
//		while(rs.next()) {
//			DeptOrigin dept = DeptOrigin.builder().deptno(rs.getInt("deptno"))
//					.dname(rs.getString("dname"))
//					.loc(rs.getString("loc")).build();
//			list.add(dept);
//		}
//		model.addAttribute("list",list);
//		return "root";
//	}
//	
//
//
//	@Autowired
//	private Service service;
//
//	@GetMapping("/viewDept/{deptno}")
//	public String viewEmployeesByDept1(@PathVariable("deptno") int deptno, Model model) {
//	    List<EmpOrigin> employees = service.findEmployeesByDepartmentNumber(deptno); // 사원 목록 조회
//	    model.addAttribute("employees", employees); // 모델에 사원 목록 추가
//	    DeptOrigin department = service.selectByDeptno(deptno); // 부서 정보 조회
//	    model.addAttribute("department", department); // 모델에 부서 정보 추가
//	    return "departmentDetail"; // 사원 목록과 부서 정보를 표시하는 뷰 이름
//	}
//	
////	@GetMapping("/memoDelete")
////	// empno를 이용해 특정 사원의 deptno를 조회합니다.
////		public Emp findEmpnoByDeptno(int empno) {
////			return empDao.selectByEmpno(empno);
////		}
//	
////	@GetMapping("/index")
////	public String index() {
//////		System.out.println(memberDao.count());
////
//////		model.addAttribute("list", memberService.listAll());
////		return "index";
////	}
//
////	@PostMapping("/view")
////	public String memo(Model model) {
//////		System.out.println(memberDao.count);
//////		model.addAttribute("str","DB값");
//////		model.addAttribute("count",memberDao.count());
////
////		System.out.println(" service.selectAll()" + service.selectList());
////		model.addAttribute("list", service.selectAll());
////		return "view";
////
////	}
//	
//	
////	//입력 Dept
////	@PostMapping("/inputD")
////	public String inputD(Model model, Dept dept) {
//////		System.out.println(memberDao.count);
//////		model.addAttribute("str","DB값");
//////		model.addAttribute("count",memberDao.count());
//////		System.out.println("회원번호는:"+memberno+"입니다");
////		
//////		System.out.println("회원번호는:"+memberno+"입니다");
////		
////		System.out.println("dept신규데이터가 입력되었습니다" + dept);
////		service.insertD(dept);
////		model.addAttribute("list", service.selectDeptList());
////		return "root";
////	}
//	//입력 Emp
//		@PostMapping("/inputE")
//		public String inputE(Model model, EmpOrigin emp) {
////			System.out.println(memberDao.count);
////			model.addAttribute("str","DB값");
////			model.addAttribute("count",memberDao.count());
////			System.out.println("회원번호는:"+memberno+"입니다");
//			
////			System.out.println("회원번호는:"+memberno+"입니다");
//			
//			System.out.println("emp신규데이터가 입력되었습니다" + emp);
//			service.insertE(emp);
//			model.addAttribute("list", service.selectEmpList());
//			return "root";
//		}
//	
//	
//
////	@GetMapping("/update")
////	public String update(Model model,int memberno) {
////		
////		model.addAttribute("list", memberService.selectAll());
////		return "updateForm";
////		
////	}
//	@PostMapping("/updateE")
//	public String updateE(Model model, int empno,  String ename, String job ,int mgr,
//			 String hiredate,int sal, int comm, int deptno) {
//		EmpOrigin emp = new EmpOrigin(empno, ename, job , mgr,
//				 hiredate, sal, comm, deptno );
//		System.out.println("emp 데이터업데이트");
//		service.updateE(emp);
//		model.addAttribute("list", service.selectEmpList());
//		return "view";
//
//	}
//	
//	//수정D
////	@PostMapping("/updateD")
////	public String updateD(Model model, int deptno,  String dname, String loc) {
////		Dept dept = new Dept(deptno, dname, loc );
////		System.out.println("dept 데이터업데이트");
////		service.updateD(dept);
////		model.addAttribute("list", service.selectDeptList());
////		return "view";
////
////	}
//	
////	
////	@GetMapping("/updateForm")
////	public String updateForm( Model model, @RequestParam int memberno) {
////
////		model.addAttribute("member", memberService.findByMemberno(memberno));
////		model.addAttribute("list", memberService.selectAll());
//////		return "updateForm";
////		return "view";
////
////	}
//
////	//삭제D
////	@GetMapping("/deleteD")
////	public String deleteD(Model model, @RequestParam int deptno) {
////		System.out.println("dept데이터삭제");
////
////		service.deleteD(deptno);
////		model.addAttribute("list", service.selectDeptList());
////		return "view";
////	}
//	@GetMapping("/deleteE")
//	public String deleteE(Model model, @RequestParam int empno) {
//		System.out.println("emp데이터삭제");
//
//		service.deleteE(empno);
//		model.addAttribute("list", service.selectEmpList());
//		return "view";
//	}
//	
////	@GetMapping("/delete")
////	public String delete(Model model, @RequestParam int memberno) {
////		System.out.println("데이터삭제");
////
////		memberService.delete(memberno);
////		model.addAttribute("list", memberService.selectAll());
////		return "view";
////	}
//
////	@GetMapping("/deleteForm")
////	public String deleteForm(Model model, int memberno) {
////
////		model.addAttribute("member", memberService.findByMemberno(memberno));
////		model.addAttribute("list", memberService.selectAll());
//////		return "deleteForm";
////		return "view";
////
////	}
//	
////	@GetMapping("/memoUpdate")
////	public String memoUpdate(@RequestParam("memberno") int memberno, @RequestParam("memo") String memo, Model model) {
////	    memberService.memoUpdate(memberno, memo);
////	    model.addAttribute("list", memberService.selectAll());
////	    return "view"; // 업데이트 후 목록 페이지로 리디렉션
////	}
////
////	@GetMapping("/memoDelete")
////	public String memoDelete(@RequestParam("memberno") int memberno, Model model) {
////	    memberService.memoDelete(memberno);
////	    model.addAttribute("list", memberService.selectAll());
////	    return "view"; // 삭제 후 목록 페이지로 리디렉션
////	}
////	
////	
////	@GetMapping("/memoDelete")
////	// empno를 이용해 특정 사원의 deptno를 조회합니다.
////		public Emp findEmpnoByDeptno(int empno) {
////			return empDao.selectByEmpno(empno);
////		}
////	
////	public String findEmpnoByDeptno(int empno) {
////        return jdbcTemplate.queryForObject("SELECT deptno FROM emp WHERE empno = ?", 
////                                           new Object[]{empno}, String.class);
////    }
//	
////	// deptno를 이용해 특정 사원의 empno 사원번호를 조회합니다.
////		public String findEmpnoByDeptno(int deptno) {
////			  return jdbcTemplate.queryForObject("SELECT empno FROM emp WHERE deptno = ?", 
////			                                     new Object[]{deptno}, String.class);
////		}
////	
////	// empno를 이용해 특정 사원의 deptno부서번호를 조회합니다.
////	public String findDeptnoByEmpno(int empno) {
////  return jdbcTemplate.queryForObject("SELECT deptno FROM emp WHERE empno = ?", 
////                                     new Object[]{empno}, String.class);
////	}
//	
////	// 부서 번호 클릭 시 직원 목록을 표시하는 새로운 메소드를 추가합니다.
////    @GetMapping("/department/{deptno}")
////    public String showEmployeesByDepartment(@PathVariable int deptno, Model model) {
////        // 선택된 부서에 속한 직원 목록을 가져옵니다.
////        List<Emp> employees = service.findEmployeesByDepartmentNumber(deptno);
////        model.addAttribute("employees", employees);
////        
////        // 부서 정보도 가져옵니다.
////        Dept department = service.findEmployeesByDepartmentNumber(deptno);
////        model.addAttribute("department", department);
////        
////        // 직원 목록 페이지를 반환합니다.
////        return "departmentDetail";
////    }
////	@GetMapping("/selectEmp")
////	public String selectEmpByDept(@RequestParam("deptno") int deptno, Model model) {
////	    List<Emp> employees = service.findEmployeesByDepartmentNumber(deptno);
////	    model.addAttribute("employees", employees);
////	    Dept department = service.findDepartmentByNumber(deptno);
////	    model.addAttribute("department", department);
////	    return "departmentEmployees";
////	}
//	
////	
////	//그 찾아낸 deptno에 해당하는 사원번호에 해당하는 정보들을 조회
////	public Emp findEmpnoByDeptno(int empno) {
//////		return empDao.selectByEmpno(empno);
//////	}
//	// MyController.java 내
//	@GetMapping("/viewDept/{deptno}")
//	public String viewEmployeesByDept(@PathVariable("deptno") int deptno, Model model) {
//	    List<EmpOrigin> employees = service.findEmployeesByDepartmentNumber(deptno);
//	    model.addAttribute("employees", employees);
//	    // 여기서는 부서 정보도 함께 보여주고 싶다면 deptDao를 이용하여 부서 정보를 모델에 추가하세요.
//	    return "departmentDetail"; // 여기서 "departmentDetail"는 실제 뷰 파일 이름과 일치해야 합니다.
//	}
//	
//}
