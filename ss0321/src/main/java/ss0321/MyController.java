package ss0321;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String root(Model model) {
		model.addAttribute("list", memberService.selectAll());
		return "root";
	}
	
	
	@PostMapping("/insert")
	public String insert(Model model, MemberDto member) {
		System.out.println(member);
		memberService.insert(member);
		model.addAttribute("list", memberService.selectAll());
		return "root";
	}
	
	
	
}
