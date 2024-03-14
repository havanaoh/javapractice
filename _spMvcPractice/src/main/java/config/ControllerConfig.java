package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.PageController;

@Configuration
public class ControllerConfig {

	@Bean
	public PageController pageController() {
		return new PageController();
	}
}
