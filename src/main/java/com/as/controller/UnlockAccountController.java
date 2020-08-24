package com.as.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.as.model.UnlockAccount;

@Controller
public class UnlockAccountController {
       
	    @GetMapping(value="/unlockAcc")
	    public String displayUnlockAccntForm(@RequestParam("email") String email,Model model) {
	    	model.addAttribute("email", email);
	    	
	    	UnlockAccount unlockAcc = new UnlockAccount();
	    	model.addAttribute("unlockAcc", unlockAcc);
	    	return "unlockAccForm";
	    }
}
