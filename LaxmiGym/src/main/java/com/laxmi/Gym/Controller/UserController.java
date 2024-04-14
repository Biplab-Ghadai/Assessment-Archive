package com.laxmi.Gym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.laxmi.Gym.Model.User;
import com.laxmi.Gym.Repository.UserRepository;


@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/signup")
	public String showSignupForm()
	{
		return "gym3.html";
	}
	
	@PostMapping("/signup")
	public String processSignup(@RequestParam String username, @RequestParam String email, @RequestParam String password)
	{
		User user  = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		userRepository.save(user);
		
		return "redirect:/login";
	}
	
	public String processLogin(@RequestParam String email, @RequestParam String password)
	{
		User user = userRepository.findByEmail(email);
		if(user != null && user.getPassword().equals(password))
		{
			return "redirect:/dashboard";
		}
		else {
			return "gym2.html";
		}
	}
	
	
}
