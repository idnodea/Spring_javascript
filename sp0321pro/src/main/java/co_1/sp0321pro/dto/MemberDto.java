package co_1.sp0321pro.dto;

import lombok.ToString;



import co_1.sp0321pro.service.WrongIdPasswordException;

@ToString
public class MemberDto {

    private Integer memberno;
    private String id;
    private String email;
    // private String password;
    private int age;
    private String name;
    private String memo;
    // private LocalDateTime registerDateTime;
    // private String action;

	public MemberDto(Integer memberno, String id, String email, int age, String name, String memo) {
//		super();
		this.memberno = memberno;
		this.id = id;
		this.email = email;
		this.age = age;
		this.name = name;
		this.memo = memo;
	}
    
//
//    public void changePassword(String oldPassword, String newPassword) {
//        if (!password.equals(oldPassword))
//            throw new WrongIdPasswordException();
//        // this.password = newPassword;
//    }
	 public void changePassword(String oldPassword, String newPassword) {
       if (!email.equals(oldPassword))
           throw new WrongIdPasswordException();
        this.email = newPassword;
   }
//	public void changePassword(String oldEmail, String newPassword) {
//	    if (!email.equals(oldEmail)) {
//	        throw new WrongIdPasswordException("Old email does not match.");
//	    }
//	    this.email = newPassword;
//	}

	public Integer getMemberno() {
		return memberno;
	}
	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}