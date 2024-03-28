//package com.sky.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.sky.service.Service;
//
//
//
//
//
//@Controller
//public class AjaxController { //이름의미x  //컨트롤러 두개 이상있어도 되지만, 같은거 x
//	
//	@GetMapping("/ajax1")
//	public String ajax1() {
//		return "ajax1";
//	}
//	
//	@Autowired
//	private Service Service;
//
////	@GetMapping("list")
////	public String list(Model model) {
////		model.addAttribute("list",Service.selectDeptList());
////		model.addAttribute("list",Service.selectEmpList());
////		return "list";
////	}
//}
