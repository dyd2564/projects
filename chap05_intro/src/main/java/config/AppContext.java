package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com") // 패키지이름 
public class AppContext {
	
	// basePackages = "com" //com이하 패키지 검색
	// com 패키지 검색
	// com.jafa 패키지 검색
	// com.jafa.spring 패키지 검색
	
	// basePackages = "com.jafa" // com.jafa이하 패키지 검색
	// com.jafa 패키지검색
	// com.jafa.spring 패키지 검색
}
