package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dto.LoginRequest;
import service.GetMemberNumService;

@Controller
public class MyController {
	
	@Autowired
	private GetMemberNumService getMemberNumService;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/hello") // 요청
	public String hello() { // 메소드 이름 상관 없음
		return "hello"; //view의 이름
	}
	
	@GetMapping("/login")
	public String login() {
		return "inputForm";
	}
		
	@GetMapping("/result")
	public String result(LoginRequest loginRequest, Model model) {
		String str = "가나다";
		System.out.println(loginRequest.getId());
		System.out.println(loginRequest.getEmail());
		System.out.println(getMemberNumService.getNumRecords());
		model.addAttribute("str", str);
		return "result";
	}
	
	@GetMapping("/move")
	public String move() {		
		return "move";
	}
	
//	public String result(@RequestParam String id, 
//						 @RequestParam String email) {
//		System.out.println(id);
//		System.out.println(email);
//		return "result";
//	}
//	public String result(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		System.out.println(id);
//		return "result";
//	}
	
}
