package com.sky.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sky.model.Member;
import com.sky.model.Product;

@Mapper   //잊지말자
public interface MemberMapper {
	
	@Select("select count(*) from member")  //이걸 쓸 경우, xml과 같이 쓰면 안된다
	int count();
	
	@Select("select * from member")
	List<Member> selectAllMember();
	
	Member selectMemberById(Long id);
	
	@Insert("insert into member(name, city, street, zipcode) values(#{name},#{city},#{street},#{zipcode})")
	void insertMember(Member member);
	
}
