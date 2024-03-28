package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.model.OrderPro;

@Mapper
public interface OrderMapper {
	@Select("select count(*) from order_pro")
	int count();
	
    // 주문 ID로 주문 조회
    OrderPro selectOrderById(Long id);

    // 모든 주문 조회
    List<OrderPro> selectAllOrder();

    // 주문 추가
    @Insert("INSERT INTO order_pro (order_name, order_email, order_tel, prod_id) VALUES (#{orderName}, #{orderEmail}, #{orderTel}, #{prodId})")
    void insertOrder(OrderPro orderPro);

    // 주문 정보 업데이트
    void updateOrder(OrderPro orderPro);

    // 주문 삭제
    void deleteOrder(Long id);
}