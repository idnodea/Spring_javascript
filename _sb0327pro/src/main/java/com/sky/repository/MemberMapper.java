package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.model.MemberPro;

@Mapper   //잊지말자
public interface MemberMapper {
	
	@Select("select count(*) from member_pro")
	int count();
	
	MemberPro selectMemberById(Long id);
	List<MemberPro> selectAllMemberPro();
	void insertMemberPro(MemberPro memberPro);
	
}
