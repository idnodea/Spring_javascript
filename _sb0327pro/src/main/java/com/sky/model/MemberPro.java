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
public class MemberPro {
	private Long MemberId;   //리소시스-프로퍼티에서 카멜 true로 해서 가능함
	@NonNull private String memberName;  //노아규먼트를 만들면 final대신.  오른쪽 아웃라인에선 
	@NonNull private String memberEmail;
	@NonNull private int memberTel;
//		final private String prodName;
//	final private int prodPrice;
}
