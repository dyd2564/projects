package com.jafa.example06;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JdbcConnector06 {
	private String driver; 
	private String url; 
	private String username;
	private String password;
}
