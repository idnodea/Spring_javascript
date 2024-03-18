package practice;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
	
	//@Autowired  널
	
	//@Autowired   //null이 아니게 된다 //변수명으로 한 게 아님(빈의 타입을 보고 자동매칭해준것)

	private MemberDao memberDao;
	
	
	
	
	//생성자 필드+오토와이어드
	//@Autowired     // 여기엔 왜 안 넣을까요???  //질문입니다. 여기나
//	public MemberRegisterService(MemberDao memberDao) {
//		super();
//		this.memberDao = memberDao;
//	}



//	@Autowired    // 위의 생성자의 오토와이어드를 제거하고 세터에만 붙여보자-여기까지 해줘도 연결관계는 스프링이 해준다
	@Autowired    // 여기엔 왜 안 넣을까요???  //질문입니다. 여기나 
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}


	//@Autowired  빈의 타입에 붙이지(. 여기엔 붙이지 않는다.
	public void regist() {
		memberDao.process();
//		if(memberDao == null) {
//			System.out.println("memberDao가 null입니다");
//		}
		System.out.println("regist()");
	}
	
	
}
