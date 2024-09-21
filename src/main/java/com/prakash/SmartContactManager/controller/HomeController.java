package com.prakash.SmartContactManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prakash.SmartContactManager.Model.User;
import com.prakash.SmartContactManager.dao.UserRepository;

@Controller
public class HomeController {
	
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
		return "signup";
	}
}
