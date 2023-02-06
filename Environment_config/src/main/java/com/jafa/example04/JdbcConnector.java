package com.jafa.example04;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JdbcConnector {
	private String driver; 
	private String url; 
	private String username;
	private String password;
}
