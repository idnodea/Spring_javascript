package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
	//필드는 클래스의 속성,중심자료
    private MemberDao memberDao;
 
    //생성자를 통한, 의존성 주입
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    
        //dto정도면 몰라도 dao는 객체생성보다 객체주입을 따르자
        //this.memberDao = new memberDao;
    }
    
    public Long regist(RegisterRequest req) throws DuplicateMemberException {
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }
     
        Member newMember = new Member(
            req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now()
        );
     
        memberDao.insert(newMember);
        return newMember.getId();
    }
}