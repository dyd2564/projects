package spring;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Member {
	
	@Setter
	private Long id; 
	private String email; 
	private String password; 
	private String name; 
	private LocalDateTime registerDateTime;
	
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}

	public void changePassword(String oldPwd, String newPwd) {
		if(!this.password.equals(oldPwd)) { // 기존의 비밀번호가 일치하지 않으면 
			throw new WrongIdPasswordException(); // '비밀번호잘못됨'예외 발생
		}
		this.password = newPwd; // 비밀번호 변경 
	}
	
	
}
