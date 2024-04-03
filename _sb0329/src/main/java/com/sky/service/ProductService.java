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

    @Transactional
    public void insertProduct(Product product) {

        productMapper.insertProduct(product);
    }

	public void deleteProduct(Long prodId) {
		// TODO Auto-generated method stub
		productMapper.deleteProduct(prodId);
	}
    
//    void delete(Long prodId);
//    @Override
//    public void deleteProductById(Long prodId) {
//        productRepository.deleteById(prodId);  // 제품 삭제
//    }
}
