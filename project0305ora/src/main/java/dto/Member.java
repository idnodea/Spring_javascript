package dto;

public class Member {
	//id, password, name, gender, email, memberno(원시키)
	private int memberno;
	private String memberID;
	private String memberPassword;
	private String memberName;
	private String memberGender;
	private String memberEmail;
	
	
	
	
	
	public Member(int memberno, String memberID, String memberPassword, String memberName, String memberGender,
			String memberEmail) {
		super();
		this.memberno = memberno;
		this.memberID = memberID;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberEmail = memberEmail;
	}
	
	
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	@Override
	public String toString() {
		return "Member [memberno=" + memberno + ", memberID=" + memberID + ", memberPassword=" + memberPassword
				+ ", memberName=" + memberName + ", memberGender=" + memberGender + ", memberEmail=" + memberEmail
				+ "]";
	}
	
	
}
