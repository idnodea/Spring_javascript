package com.sky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//모델하고 이름을 같이 하는 건 별로 좋진 않지만, 지금은
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;       
	
	private String memberName;
	private String memberCity;
	private String memberStreet;
	private String memberZipcode;
}
