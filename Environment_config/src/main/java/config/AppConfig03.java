package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jafa.example03.JdbcConnector;

@Configuration
@PropertySource(value = {
		"classpath:example03/oracle.properties",
		"classpath:example03/mysql.properties"
})
public class AppConfig03 {

	@Autowired
	Environment environment;
	
	@Bean
	public JdbcConnector jdbcConnector() {
		JdbcConnector jdbcConnector = new JdbcConnector();
		jdbcConnector.setDriver(environment.getProperty("db.driver"));
		jdbcConnector.setUrl(environment.getProperty("db.url"));
		jdbcConnector.setUsername(environment.getProperty("db.username"));
		jdbcConnector.setPassword(environment.getProperty("db.password"));
		return jdbcConnector; 
	}
	
}
