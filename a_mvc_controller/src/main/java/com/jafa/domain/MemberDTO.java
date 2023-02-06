package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class MemberDTO {
	String userName; 
	String userPassword;
	String email;
}
