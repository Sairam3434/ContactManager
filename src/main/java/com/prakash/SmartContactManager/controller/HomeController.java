package com.prakash.SmartContactManager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.SmartContactManager.Model.User;
import com.prakash.SmartContactManager.dao.UserRepository;
import com.prakash.SmartContactManager.helper.Message;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userrepo;
	
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title","Home - Smart contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title","Home - Smart contact Manager");
		return "about";
	}
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("title","Register - Smart contact Manager");
		model.addAttribute("user", new User());
		return "signup";
	}
	
	@RequestMapping(value="/do_register", method =RequestMethod.POST)
	public String Register(@Valid @ModelAttribute("user") User user,BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement,Model model, HttpSession session) {
		try {
			if(!agreement) {
				//System.out.println("You have not agreed the terms and conditions");
				throw new Exception("You have not agreed the terms and conditions");
			}
			if(result1.hasErrors()) {
				System.out.println("ERROR"+ result1.toString());
				model.addAttribute("user"+user);
				return "signup";
			}
			user.setRole("ROLE_USER");
			user.setEnabled(true);
			user.setImageurl("default.png");
			
			
			
			System.out.println("Agreement"+agreement);
			System.out.println("USER"+user);
			User result = this.userrepo.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Message("Successfully Registered!!","alert-success"));
			return "signup";
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
		session.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(),"alert-danger"));
		return "signup";
		}
		
	}
	
}
