package com.zadaca1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, Role role) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
        user.setEnabled(true);
        role.setID(1);
		
		userRepository.save(user);
		
		return "register_success";
	}

    @GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/admin")
	public String listUsers() {
		return "admin";
	}

    @GetMapping("/greska")
	public String greska() {
		return "greska";
	}

}