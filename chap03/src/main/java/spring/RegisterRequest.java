package spring;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest { // MemberDTO
	private String email; 
	private String password;
	private String confirmPassword;
	private String name;
	
	public boolean isPasswordEqualToConfirmPasswrod() {
		return password.equals(confirmPassword);
	} 
}
