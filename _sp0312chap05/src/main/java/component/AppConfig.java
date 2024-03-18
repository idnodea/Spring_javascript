package component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	
	@Bean
	public UserService userservice() {
		return new UserService();
	}
	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}
}
