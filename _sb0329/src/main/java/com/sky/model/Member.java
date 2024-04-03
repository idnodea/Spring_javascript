package com.sky.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor  
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {
	private Long memberId;   //리소시스-프로퍼티에서 카멜 true로 해서 가능함
	@NonNull private String memberName;  //노아규먼트를 만들면 final대신.  오른쪽 아웃라인에선 
	@NonNull private String memberCity;
	@NonNull private String memberStreet;
	@NonNull private String memberZipcode;
//		final private String prodName;
//	final private int prodPrice;
}
