package com.ruralivrs.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ruralivrs.domain.User;
import com.ruralivrs.domain.UserComplete;
import com.ruralivrs.domain.userRegistration;
import com.ruralivrs.service.UserService;
import com.ruralivrs.service.userRegistrationService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private userRegistrationService userRegistrationService;
	
	private User admin = new User();
	
	@RequestMapping(value="/RegisterForm",method = RequestMethod.GET)
	public ModelAndView getRegisterForm2(@ModelAttribute("user") UserComplete user,
			BindingResult result){	
		System.out.println("Register-step2");
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("RegisterForm", "model", model);
	}
	@RequestMapping(value="/confirm",method = RequestMethod.POST)
	public ModelAndView saveNewuser(@Valid @ModelAttribute("user") UserComplete user,
			BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return new ModelAndView("redirect:/RegisterForm.html");
		}else{
		System.out.println("Confirm User");
		userService.addNewuser(user.getAdmin());
		model.addAttribute("id", user.getAdmin().getId());
		User users=userService.getUserfromId(user.getAdmin().getId());
		System.out.println(users.getUsername());
		model.addAttribute("admin",users);
		System.out.println(users.getUsername());
		return new ModelAndView("Register", "model", model);
		}
	}
	@RequestMapping(value="/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") UserComplete user,
			BindingResult result,ModelMap model) {
		if(result.hasErrors()){
			System.out.println("error occureed in register "+ result.toString());
            return new ModelAndView("redirect:/RegisterForm.html");
		}else{
		System.out.println("admin is get");
		System.out.println("Register-step1");
		return new ModelAndView("Register", "model", model);
		}
	}

	@RequestMapping(value="/saveUser")
	public String saveUserData(@Valid @ModelAttribute("user") UserComplete user,BindingResult result) {
		/*if(result.hasErrors()){
			System.out.println("error occureed"+ result.toString());
            return "Register";
		}else{*/
		userRegistration admindetails=user.getAdminDetails();
		//System.out.println("admin id in save username from random shit"+ admin.getUsername());
		long id=user.getId();
		System.out.println("id in save iser is "+id);
		User users =userService.getUserfromId(id);
		System.out.println("User name found is "+users.getUsername());
		admindetails.setAdmin(users);
		userRegistrationService.addUser(admindetails);
		
		System.out.println("Save userRegistration Data");
		System.out.println("Id excavated is "+user.getAdminDetails().getId());
		System.out.println("id should be" + id);
		return "redirect:/login.html";
		
		//}

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