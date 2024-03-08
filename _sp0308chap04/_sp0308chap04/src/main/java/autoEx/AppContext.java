package autoEx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	//설계를 쓰세요~?
	
	@Bean
	public Tire tire() {
		return new Tire();
	}
	
	@Bean
	public Car car() {		
		return new Car();
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
	
}
