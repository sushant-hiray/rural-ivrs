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
import com.ruralivrs.domain.userRegistration;
import com.ruralivrs.service.UserService;
import com.ruralivrs.service.userRegistrationService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private userRegistrationService userRegistrationService;
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showForm(ModelMap model){
        User user = new User();
        model.addAttribute("USER", user);
        return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute(value="USER") User user,BindingResult result){
        if(result.hasErrors()){
                   
                    return "register";
        }else{
                    System.out.println("User values is : " + user);
                    return "saveUser";
        }                      
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
		Map<String, Object> model = new HashMap<String, Object>();
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
	
	@RequestMapping(value="/checkAvailability",method=RequestMethod.GET)
	public @ResponseBody boolean getAvailability(@RequestParam String name) {
	    for (User a : userService.getUser()) {
	        if (a.getFirstName().equals(name)) {
	            return false;
	        }
	    }
	    return true;
	}

	
	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		return new ModelAndView("UserDetails", model);

	}
}
