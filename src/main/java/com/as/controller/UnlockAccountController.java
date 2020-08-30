package com.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.as.constants.AppConstants;
import com.as.model.UnlockAccount;
import com.as.model.UserAccount;
import com.as.service.UserAccountService;

@Controller
public class UnlockAccountController {
	   
	   @Autowired
	   private UserAccountService uAccService;
       
	    @GetMapping(value="/unlockAcc")
	    public String displayUnlockAccntForm(@RequestParam("email") String email,Model model) {
	    	model.addAttribute("email", email);
	    	UnlockAccount unlockAcc = new UnlockAccount();
	    	model.addAttribute("unlockAcc", unlockAcc);
	    	return "unlockAccForm";
	    }
	    
	    @RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	    public String handleUnlockBtn(@ModelAttribute("unlockAcc") UnlockAccount unlockAccount, Model model) {
	    	UserAccount accnt = uAccService.getAccountByTempPwd(unlockAccount.getTempPwd());
	    	accnt.setAccStatus(AppConstants.UNLOCKED_STR);
	    	accnt.setTempPwd(unlockAccount.getConfirmPwd());
	    	boolean isTemPwdUpdated = uAccService.updateAccount(accnt);
	    	return "unlockSuccess";
	    }
}
