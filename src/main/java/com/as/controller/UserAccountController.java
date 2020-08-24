package com.as.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.as.model.UserAccount;
import com.as.service.UserAccountService;

@Controller
public class UserAccountController {
            
	         @Autowired
	         private UserAccountService uAccService;
	        
	        @GetMapping("/loadForm")
	        public String loadForm(Model model) {
	        	UserAccount uAcc = new UserAccount();
	                    Map<Integer,String> roleMap =  uAccService.getAllRoles();
	                    model.addAttribute("userAcc", uAcc);
	                    model.addAttribute("roleMap", roleMap);
	        	return "userCreationForm";
	        }
	        
	        @RequestMapping(value = "/userAccReg", method = RequestMethod.POST)
	        public String handleSubmitBtn(@ModelAttribute("userAcc") UserAccount uAcc, Model model) {
	        	boolean isSaved = uAccService.createAccount(uAcc);
	        	return "userAccCreationSuccess";
	        }
}
