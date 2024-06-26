package com.sky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class products {
	
	@Id													//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private Long prodId;       
	
	private String prodName;
	private Long prodPrice;
}
