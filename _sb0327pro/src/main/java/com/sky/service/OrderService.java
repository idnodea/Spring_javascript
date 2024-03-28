package com.sky.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.model.OrderPro;
import com.sky.model.Product;
import com.sky.repository.OrderMapper;

@Service
public class OrderService {
	@Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductService productService;

    public OrderPro getOrderById(Long id) {
        return orderMapper.selectOrderById(id);
    }

    public List<OrderPro> getAllOrders() {
        return orderMapper.selectAllOrder();
    }

    @Transactional
    public void insertOrder(OrderPro order, Product product) {
    
        productService.insertProduct(product); // 제품 추가
        order.setProdId(product.getProdId()); // 제품 ID 설정
        order.setProdQt(product.getProdQt()); //제품수량에 맞는지
        orderMapper.insertOrder(order); // 주문 추가
    }

    @Transactional
    public void updateOrder(OrderPro order) {
        orderMapper.updateOrder(order);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        orderMapper.deleteOrder(orderId);
    }
//    @Autowired
//    private OrderMapper orderMapper;
//    @Autowired
//    private ProductService productService;
//
//    public OrderPro getOrderById(Long id) {
//        return orderMapper.selectOrderById(id);
//    }
//
//    public List<OrderPro> getAllOrders() {
//        return orderMapper.selectAllOrder();
//    }
//
//    @Transactional
//    public void addOrder(OrderPro orderPro, Product product) {
//        long prodId = productService.insertProduct(product); // 제품 추가 후 prod_id 반환
//        orderPro.setProId(prodId); // OrderPro 객체에 prod_id 설정
//        orderMapper.insertOrder(orderPro);
//    }
//
//    public void updateOrder(OrderPro order) {
//        orderMapper.updateOrder(order);
//    }
//
//    public void deleteOrder(Long id) {
//        orderMapper.deleteOrder(id);
//    }
}
