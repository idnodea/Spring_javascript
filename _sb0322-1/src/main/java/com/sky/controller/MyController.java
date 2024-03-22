package com.sky.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.dto.Dept;
import com.sky.dto.Emp;
import com.sky.service.Service;

@Controller
public class MyController {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/")
	public String root(Model model) {
		List<Dept> list = new ArrayList<>();
		SqlRowSet rs = jdbcTemplate.queryForRowSet("select * from dept");
		while(rs.next()) {
			Dept dept = Dept.builder().deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc")).build();
			list.add(dept);
		}
		model.addAttribute("list",list);
		return "root";
	}
	


	@Autowired
	private Service service;

//	@GetMapping("/index")
//	public String index() {
////		System.out.println(memberDao.count());
//
////		model.addAttribute("list", memberService.listAll());
//		return "index";
//	}

//	@PostMapping("/view")
//	public String memo(Model model) {
////		System.out.println(memberDao.count);
////		model.addAttribute("str","DB값");
////		model.addAttribute("count",memberDao.count());
//
//		System.out.println(" service.selectAll()" + service.selectList());
//		model.addAttribute("list", service.selectAll());
//		return "view";
//
//	}
	
	
	//입력 Dept
	@PostMapping("/inputD")
	public String inputD(Model model, Dept dept) {
//		System.out.println(memberDao.count);
//		model.addAttribute("str","DB값");
//		model.addAttribute("count",memberDao.count());
//		System.out.println("회원번호는:"+memberno+"입니다");
		
//		System.out.println("회원번호는:"+memberno+"입니다");
		
		System.out.println("dept신규데이터가 입력되었습니다" + dept);
		service.insertD(dept);
		model.addAttribute("list", service.selectDeptList());
		return "root";
	}
	//입력 Emp
		@PostMapping("/inputE")
		public String inputE(Model model, Emp emp) {
//			System.out.println(memberDao.count);
//			model.addAttribute("str","DB값");
//			model.addAttribute("count",memberDao.count());
//			System.out.println("회원번호는:"+memberno+"입니다");
			
//			System.out.println("회원번호는:"+memberno+"입니다");
			
			System.out.println("emp신규데이터가 입력되었습니다" + emp);
			service.insertE(emp);
			model.addAttribute("list", service.selectEmpList());
			return "root";
		}
	
	

//	@GetMapping("/update")
//	public String update(Model model,int memberno) {
//		
//		model.addAttribute("list", memberService.selectAll());
//		return "updateForm";
//		
//	}
	@PostMapping("/updateE")
	public String updateE(Model model, int empno,  String ename, String job ,int mgr,
			 String hiredate,int sal, int comm, int deptno) {
		Emp emp = new Emp(empno, ename, job , mgr,
				 hiredate, sal, comm, deptno );
		System.out.println("emp 데이터업데이트");
		service.updateE(emp);
		model.addAttribute("list", service.selectEmpList());
		return "view";

	}
	@PostMapping("/updateD")
	public String updateD(Model model, int deptno,  String dname, String loc) {
		Dept dept = new Dept(deptno, dname, loc );
		System.out.println("dept 데이터업데이트");
		service.updateD(dept);
		model.addAttribute("list", service.selectDeptList());
		return "view";

	}
	
//	
//	@GetMapping("/updateForm")
//	public String updateForm( Model model, @RequestParam int memberno) {
//
//		model.addAttribute("member", memberService.findByMemberno(memberno));
//		model.addAttribute("list", memberService.selectAll());
////		return "updateForm";
//		return "view";
//
//	}

	
	@GetMapping("/deleteD")
	public String deleteD(Model model, @RequestParam int deptno) {
		System.out.println("dept데이터삭제");

		service.deleteD(deptno);
		model.addAttribute("list", service.selectDeptList());
		return "view";
	}
	@GetMapping("/deleteE")
	public String deleteE(Model model, @RequestParam int empno) {
		System.out.println("emp데이터삭제");

		service.deleteE(empno);
		model.addAttribute("list", service.selectEmpList());
		return "view";
	}
	
//	@GetMapping("/delete")
//	public String delete(Model model, @RequestParam int memberno) {
//		System.out.println("데이터삭제");
//
//		memberService.delete(memberno);
//		model.addAttribute("list", memberService.selectAll());
//		return "view";
//	}

//	@GetMapping("/deleteForm")
//	public String deleteForm(Model model, int memberno) {
//
//		model.addAttribute("member", memberService.findByMemberno(memberno));
//		model.addAttribute("list", memberService.selectAll());
////		return "deleteForm";
//		return "view";
//
//	}
	
//	@GetMapping("/memoUpdate")
//	public String memoUpdate(@RequestParam("memberno") int memberno, @RequestParam("memo") String memo, Model model) {
//	    memberService.memoUpdate(memberno, memo);
//	    model.addAttribute("list", memberService.selectAll());
//	    return "view"; // 업데이트 후 목록 페이지로 리디렉션
//	}
//
//	@GetMapping("/memoDelete")
//	public String memoDelete(@RequestParam("memberno") int memberno, Model model) {
//	    memberService.memoDelete(memberno);
//	    model.addAttribute("list", memberService.selectAll());
//	    return "view"; // 삭제 후 목록 페이지로 리디렉션
//	}
//	
//	
//	@GetMapping("/memoDelete")
//	// empno를 이용해 특정 사원의 deptno를 조회합니다.
//		public Emp findEmpnoByDeptno(int empno) {
//			return empDao.selectByEmpno(empno);
//		}
//	
//	public String findEmpnoByDeptno(int empno) {
//        return jdbcTemplate.queryForObject("SELECT deptno FROM emp WHERE empno = ?", 
//                                           new Object[]{empno}, String.class);
//    }
	
}
