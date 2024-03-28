package com.sky.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;   //롬복임
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor  //final을 붙이면 사용불가
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class OrderPro {
	private Long OrderId;   //리소시스-프로퍼티에서 카멜 true로 해서 가능함
	@NonNull private String orderName;  //노아규먼트를 만들면 final대신.  오른쪽 아웃라인에선 
	@NonNull private String OrderEmail;
	@NonNull private String OrderTel;
	@NonNull private Long prodId; // 상품 ID 필드 추가
	@NonNull private Long orderQt;
//		final private String prodName;
//	final private int prodPrice;
}
