package spring2;


//0313  복사 대신 옮기기.
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import config.ManualBean;
import spring.DuplicateMemberException;
import spring.Member;
import spring.MemberDao;
import spring.RegisterRequest;

@ManualBean//0313 추가 2교시
@Component("memberRegSvc")//0313 추가  2교시
public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

//	public MemberRegisterService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName(), 
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
