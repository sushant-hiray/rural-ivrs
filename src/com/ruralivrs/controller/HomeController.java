package com.ruralivrs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}
	@RequestMapping("/saveUser")
	public ModelAndView saveUserData(@ModelAttribute("user") userRegistration user,
			BindingResult result) {
		userRegistrationService.addUser(user);
		System.out.println("Save userRegistration Data");
		return new ModelAndView("redirect:/RegisterForm.html");
		
	}
	@RequestMapping("/RegisterForm")
	public ModelAndView getRegisterForm2(@ModelAttribute("user") User user,
			BindingResult result){	
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("RegisterForm", "model", model);
	}
	@RequestMapping("/confirm")
	public ModelAndView saveNewuser(@ModelAttribute("user") User user,
			BindingResult result){
		userService.addNewuser(user);
		return new ModelAndView("redirect:/login.html");
	}
	@RequestMapping("/login")
	public ModelAndView getLoginForm(@ModelAttribute("user") User user,
			BindingResult result) {
		//ArrayList<String> gender = new ArrayList<String>();
		/*gender.add("Male");
		gender.add("Female");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");*/
		Map<String, Object> model = new HashMap<String, Object>();
		//model.put("gender", gender);
		//model.put("city", city);
		System.out.println("Login Form");
		return new ModelAndView("Login", "model", model);
	}

	@RequestMapping("/checkUser")
	public ModelAndView checkUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		if(userService.addUser(user).equals("successful"))
			return new ModelAndView("redirect:/userList.html");
		else
		return new ModelAndView("redirect:/login.html");
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		return new ModelAndView("UserDetails", model);

	}
}
