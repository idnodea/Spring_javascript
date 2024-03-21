package main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import dbquery.DbQuery;
import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForDao {

	private static Logger LOGGER = LoggerFactory.getLogger(MainForDao.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);

		MemberDao dao = ctx.getBean(MemberDao.class);
//		Member member = dao.selectByEmail("madvirus@madvirus.net"); //만약 숫자라도 들어가면? 오류->고치려면
		
		
		//신규두번째 테스트
//		Member member2 = new Member("Kim@korea.com","1234","김두두",null);
//		dao.insert2(member2);
//		LOGGER.info("----한 행이 입력되었습니다.");
//		
		//신규첫번째 테스트
//		Member member2 = new Member("abc@korea.com","1234","홍길동",null);
//		dao.insert2(member2);
//		LOGGER.info("----한 행이 입력되었습니다.");
		
		//수정
//		Member member3 = new Member("abc@korea.com","5678","홍동주",null);
//		dao.update(member3);
//		LOGGER.info("----한 행이 수정되었습니다.");
//		
		
		Member member2 = new Member("Kim33@korea.com","1234","김길동3",null);
		dao.insert2(member2);
		LOGGER.info("키홀더추가 후 신규 테스트--한행이 입력되었습니다.");
		LOGGER.info("새로 입력된 회원 아이디:{}",member2.getId());
		
		
		int cnt =dao.count();
		LOGGER.info("총인원수: {}", cnt);
		
		List<Member> list =dao.selectAll();
		LOGGER.info("---Member테이블 내용---");
		for(Member member : list) {
			LOGGER.info(member.toString());
		}
		LOGGER.info("---Member테이블 끝---");
		Member member = dao.selectByEmail3("madvirus@madvirus.net");
		
		if(member != null) {
			LOGGER.info("아이디:{}, 이메일:{}, 패스워드:{}, 이름:{}, 등록일:{}",
                    member.getId(), 
                    member.getEmail(),
                    member.getPassword(),
                    member.getName(),
                    member.getRegisterDateTime());
		}else {
			LOGGER.info("이메일로 검색안됨");
		}
		//		LOGGER.info("{}",member);// 널포인트에러를 잡기위한코드
//				LOGGER.info("아이디:{}, 이메일:{}, 패스워드:{}, 이름:{}, 등록일:{}",
//				                      member.getId(), 
//				                      member.getEmail(),
//				                      member.getPassword(),
//				                      member.getName(),
//				                      member.getRegisterDateTime());

		ctx.close();

	}
}