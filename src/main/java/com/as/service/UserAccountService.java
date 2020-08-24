package com.as.service;

import java.util.Map;

import com.as.model.UserAccount;

public interface UserAccountService {
                     
	             public boolean createAccount(UserAccount userAcc);
	             public Map<Integer, String> getAllRoles();
}
