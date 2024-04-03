package com.sky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sky.model.Product;
import com.sky.repository.ProductMapper;
import com.sky.service.ProductService;

@Controller
public class MyController {
	
	@Autowired
//	ProductMapper productMapper;
	ProductService productService;
	
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("memberName", "홍길동");  //매스터치 이름과 같아야함
		model.addAttribute("aaa", "가나다");  //모델패키지 안의 이름과 같음
//		model.addAttribute("product", productService.getProductById(3L)); 
		model.addAttribute("product", productService.getProductById(3L)); 
		return "main";
		//return "redirect:list";
	}
	
	@GetMapping("list")  //요청명
	public String list(Model model) {
		
		model.addAttribute("list", productService.getAllProducts());  //이 이름이 머스태치의 이름
		return "list";    //반환되는 곳
	}
	
	@GetMapping("/save")
	public String saveProduct(Product product, Model model) {
	    productService.insertProduct(product);
	    return "main";  // 제품 목록 페이지로 리다이렉트
	}
	
	@PostMapping("/insertProduct")
	public String insertProduct(Product product) {
	    productService.insertProduct(product);
	    return "redirect:list";  // 제품 목록 페이지로 리다이렉트
	}
	
	@GetMapping("/update/{prodId}")
	public String update(@PathVariable Long prodId, Model model) {
	    // 제품 정보를 조회하여 모델에 추가하는 로직이 필요함
	    model.addAttribute("product", productService.getProductById(prodId));
	    return "update";  // "update.mustache"로 이동
	}
	
	@PostMapping("/delete")
    public String delete(@RequestParam("prodId") Long prodId) {
        productService.deleteProduct(prodId);  // 제품 삭제 서비스 호출
        return "redirect:list";  // 삭제 후 제품 목록 페이지로 리다이렉트
    }
}
