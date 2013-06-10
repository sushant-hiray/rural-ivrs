package com.ruralivrs.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ruralivrs.domain.User;
import com.ruralivrs.domain.userRegistration;
import com.ruralivrs.service.UserService;
import com.ruralivrs.service.userRegistrationService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private userRegistrationService userRegistrationService;
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") userRegistration user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("Register-step1");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping("/saveUser")
	public String saveUserData(@Valid @ModelAttribute("user") userRegistration user,
			BindingResult result) {
		if(result.hasErrors()){
            
            return "Register";
		}else{
		userRegistrationService.addUser(user);
		System.out.println("Save userRegistration Data");
		return "redirect:/login.html";
		}

	}
	@RequestMapping("/RegisterForm")
	public ModelAndView getRegisterForm2(@ModelAttribute("user") User user,
			BindingResult result){	
		System.out.println("Register-step2");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("RegisterForm", "model", model);
	}
	@RequestMapping("/confirm")
	public String saveNewuser(@Valid @ModelAttribute("user") User user,
			BindingResult result){
		if(result.hasErrors()){
			return "RegisterForm";
		}else{
		System.out.println("Confirm User");
		userService.addNewuser(user);
		return "redirect:/register.html";
		}
	}
	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute("user") User user,
			BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("Login Form");
		return new ModelAndView("Login", "model", model);
	}

	@RequestMapping("/checkUser")
	public ModelAndView checkUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		if(userService.addUser(user).equals("successful"))
			return new ModelAndView("redirect:/Dashboard.html");
		else
		return new ModelAndView("redirect:/register.html");
	}
	
	@RequestMapping(value="/person",method=RequestMethod.GET)
	public @ResponseBody String getAvailability(@RequestParam String name) {
		System.out.println("Username received is" + name);
	    for (User a : userService.getUser()) {
	    	System.out.println("retreived Uername is " + a.getUsername());
	        if (a.getUsername().equals(name)) {
	            return "false";
	        }
	    }
	    return "true";
	}


	@RequestMapping("/Dashboard")
	public ModelAndView getUserList() {
		return new ModelAndView("Dashboard");

	}
	
	
}