package spring;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {   //생성자 주석처리  //다시 해제
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"); //패턴을 바꿔준다
	}
	
	public void print(Member member) {  
		System.out.println("dateTimeFormatter: " + dateTimeFormatter);
		if (dateTimeFormatter == null) {  //
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(),
					member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf(
					"회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(),
					member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
//	@Autowired    //빈에 등록시킨 일은 없지만, import로 받아옴. 
					//그럼 오류날걸 알면서 왜 썼을까?
//	@Autowired(required = false)   //(=필수가 아니다)		
	@Autowired(required = false)   //(=필수가 아니다)->주석처리
//	@Autowired   //매개 변수 필수로 주입
//	public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {  //아래와같이 널러블추가
//	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) { //리콰이어드와같음
	public void setDateFormatter( DateTimeFormatter dateTimeFormatter) { //리콰이어드와같음
		this.dateTimeFormatter = dateTimeFormatter;
	}

}
