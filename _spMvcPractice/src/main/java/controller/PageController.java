package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dto.Login;

@Controller
public class PageController {
	@GetMapping("/")
	public String root() {
		return "index";		
	}
	
	@GetMapping("/inputForm")
	public String login() {
		return "inputForm";
	}
	
	@GetMapping("/result")
	public String result(Login login) {		
		return "result";
	}
	
	@GetMapping("/move")
	public String move() {		
		return "index";
	}
}
