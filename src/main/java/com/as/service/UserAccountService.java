package com.as.service;

import java.util.List;
import java.util.Map;

import com.as.model.RoleMaster;
import com.as.model.UnlockAccount;
import com.as.model.UserAccount;

public interface UserAccountService {
                     
	             public boolean createAccount(UserAccount userAcc);
	             public Map<Integer, String> getAllRoles();
	             public List<UserAccount> getAllAccounts();
	             public UserAccount getAccountById(Integer id);
	            public RoleMaster getRoleById(Integer roleId); 
	            public boolean deleteAccount(Integer id);
	            public boolean updateAccount(UserAccount account);
	             public UserAccount getAccountByTempPwd(String tempPassword); 
	            public boolean updateTempPassword(UnlockAccount unlockAcc);
}
