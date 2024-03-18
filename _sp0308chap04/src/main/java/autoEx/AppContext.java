package autoEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
public class AppContext {

	@Bean//넘겨주는 게 끝이고, 넘겨준 뒤 책임지지 않는다. 널포인트이셉션등에 책임x
	public Car car() {
		return new Car();
		//run
	}
	@Bean   
	public Tire tire(){
		return new Tire();
		//roll setPosi
	}
	
	@Bean   
	public Engine engine(){
		return new Engine();
		//roll
	}
}
