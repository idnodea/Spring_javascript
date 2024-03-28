package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.sky.model.Product;

@Mapper   //잊지말자
public interface ProductMapper {
	
	@Select("select count(*) from products")
	int count();
	
	Product selectProductById(Long id);
	List<Product> selectAllProducts();


	@Insert("INSERT INTO products (prod_name, prod_price) VALUES (#{prodName}, #{prodPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "prodId")
    void insertProduct(Product product);
	
}
