package com.as.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.as.model.UserAccount;
import com.as.service.UserAccountService;

@Controller
public class ViewAccountController {
            
	       @Autowired
	       private UserAccountService uAccService;
	      
	
	     @RequestMapping(value = "/editAccount" , method = RequestMethod.GET)
	    public String editAccount(@RequestParam("id") Integer id, Model model) {
	    	UserAccount acc = uAccService.getAccountById(id);
	    	Map<Integer,String> roleMap =  uAccService.getAllRoles();
	    	model.addAttribute("userAcc", acc);
	    	model.addAttribute("roleMap", roleMap);
	    	 return "userCreationForm";
	     }
	     
	/*
	 * @RequestMapping(value = "/deleteAccount", method = RequestMethod.GET) public
	 * String deleteAccount(@RequestParam("id") Integer id) { boolean isDelete =
	 * uAccService.deleteAccount(id); return "redirect:/viewAccounts"; }
	 */
	     
	     @RequestMapping(value = {"/deleteAccount","/activateAccount"}, method = RequestMethod.GET)
	     public String deleteSwitch(@RequestParam("id")Integer id) {
	    	 UserAccount accnt = uAccService.getAccountById(id);
	    	 if(accnt.getSwitchDelete().equals("Y")) {
	    		 accnt.setSwitchDelete("N");	 
	    	 }
	    	 else {
	    		 accnt.setSwitchDelete("Y");
	    	 }
	    	boolean isUpdate = uAccService.updateAccount(accnt);
	    	 return "redirect:/viewAccounts";
	     }
	     
	     @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	        public String handleSubmitBtn(@ModelAttribute("userAcc") UserAccount uAcc, Model model) {
	    	 UserAccount acc = uAccService.getAccountById(uAcc.getUserId());
	    	 uAcc.setAccStatus(acc.getAccStatus());
	    	 uAcc.setTempPwd(acc.getTempPwd());
	    	 uAcc.setSwitchDelete(acc.getSwitchDelete());
	        	boolean isSaved = uAccService.updateAccount(uAcc);
	        	
	        		return "userAccUpdationSuccess";
	        	
	        }
	        
}
