package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.jafa.example03.LoginResult;

@Configuration
public class AppConfig04 {
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource 
						= new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames(
				"classpath:message04/welcome", 
				"file:src/main/webapp/message04/greeting"
		);
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}
}
