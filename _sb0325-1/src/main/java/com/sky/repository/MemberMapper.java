package com.sky.repository;

import org.apache.ibatis.annotations.*;

import com.sky.spring.Member;

@Mapper
public interface MemberMapper {
	
	int selectCount();
	 @Select("SELECT count(*) FROM member")
	 int count();
	
//    @Select("SELECT * FROM member WHERE email = #{email}")
//    Member selectByEmail(@Param("email") String email);
//    Member selectByEmail(@Param("aaa@korea.com") String email);
	 Member selectByEmail(@Param("email") String email);
	 
//    @Insert("INSERT INTO member (email, password, name, regdate) VALUES (#{email}, #{password}, #{name}, now())")
//    @Insert("INSERT INTO member (email, password, name, regdate) VALUES (#{email}, #{password}, #{name}, CURRENT_TIMESTAMP())")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertMember(Member member);

//    @Update("UPDATE member SET name = #{name}, password = #{password} WHERE email = #{email}")
    void updateMember(Member member);

//    @Delete("DELETE FROM member WHERE id = #{id}")
    void deleteMember(@Param("id") Long id);

   
}



//package com.sky.repository;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;
//
//
//
//import spring.Member;
//
//@Mapper
//public interface MemberMapper {
//	
//	int selectCount();
//	
//	@Select("select count(*) from member")
//	int count();
//	
//	@Select("select * from MEMBER where EMAIL = #{email}")
////	String Email();
////	String selectEmail();
//	Member selectByEmail(String email);
//	
//	@Select("INSERT INTO MEMBER\r\n"
//			+ "			(\r\n"
//			+ "			ID,\r\n"
//			+ "			EMAIL,\r\n"
//			+ "			PASSWORD,\r\n"
//			+ "			NAME,\r\n"
//			+ "			REGDATE,\r\n"
//			+ "			)\r\n"
//			+ "			values(\r\n"
//			+ "				#{ID},\r\n"
//			+ "				#{EMAIL},\r\n"
//			+ "				#{PASSWORD},\r\n"
//			+ "				#{NAME},\r\n"
//			+ "				now(),\r\n"
////			+ "				#{comm, jdbcType=NUMERIC},\r\n"
//
//			+ "			) ")
//	void insertMember(Member member); 
//	
//	
//	@Select("UPDATE MEMBER\r\n"
//			+ "        SET id = #{id}, email = #{email}, password = #{password}, name = #{name},\r\n"
//			+ "        regdate = now()"
////			+ " comm = #{comm, jdbcType=NUMERIC}, deptno = #{deptno}\r\n"
//			+ "        WHERE member = #{member}")
//	void updateMember(Member member);
//	
//	
//	@Select("delete from MEMBER where ID = #{value}")
//	void deleteMember(int id);
//}
