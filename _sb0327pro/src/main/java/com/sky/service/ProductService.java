package com.sky.service;

import com.sky.model.Product;
import com.sky.repository.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
	 @Autowired
	    private ProductMapper productMapper;

	    public Product getProductById(Long id) {
	        return productMapper.selectProductById(id);
	    }

	    public List<Product> getAllProducts() {
	        return productMapper.selectAllProducts();
	    }

	    public void insertProduct(Product product) {
	        productMapper.insertProduct(product);
	    }	
//    @Autowired
//    private ProductMapper productMapper;
//
//    // 제품 추가하고 생성된 prod_id 반환
//    public long insertProduct(Product product) {
//        productMapper.insertProduct(product);
//        return product.getProdId(); // MyBatis가 prod_id를 Product 객체에 설정하도록 해야 함
//    }
//
//    public Product getProductById(Long id) {
//        return productMapper.selectProductById(id);
//    }
//
//    public List<Product> getAllProducts() {
//        return productMapper.selectAllProducts();
//    }
}
