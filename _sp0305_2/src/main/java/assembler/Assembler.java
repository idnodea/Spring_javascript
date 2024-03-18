package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	
	public Assembler() {
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao); 
		pwdSvc  = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}
	
	//게터를 통한 서비스 호출
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
}
