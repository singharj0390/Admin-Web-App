package com.as.service;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.constants.AppConstants;
import com.as.entities.RoleMasterEntity;
import com.as.entities.UserAccountEntity;
import com.as.model.UserAccount;
import com.as.repositories.RoleRepository;
import com.as.repositories.UserAccountRepository;
import com.as.utils.EmailUtils;
import com.as.utils.PwdUtils;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountRepository uAccRepo;
	
	@Autowired
	private RoleRepository roleRepo;
     
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean createAccount(UserAccount userAcc) {
		userAcc.setTempPassword(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));  
		userAcc.setAccStatus(AppConstants.LOCKED_STR);
		
		UserAccountEntity entity = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, entity);
		
	UserAccountEntity savedEntity =  uAccRepo.save(entity);
	if(savedEntity.getUId()!=null) {
		return emailUtils.sendUserAccUnlockEmail(userAcc);
	}
	return false;
	}

	@Override
	public Map<Integer, String> getAllRoles() {
	    Map<Integer,String> roleMap = new LinkedHashMap();
	    List<RoleMasterEntity> roleList = roleRepo.findAll();
	    roleList.forEach(roleEntity->{
	    	roleMap.put(roleEntity.getRoleId(), roleEntity.getRole());
	    });
		return roleMap;
	}

	@Override
	public List<UserAccount> getAllAccounts() {
		List<UserAccountEntity> entities = uAccRepo.findAll();
		
		/*
		 * return entities.stream().map(entity -> { UserAccount account = new
		 * UserAccount(); BeanUtils.copyProperties(entity, account); return account;
		 * }).collect(Collectors.toList());
		 */
		
		List<UserAccount>  accounts = new ArrayList<UserAccount>();
		for (UserAccountEntity entity : entities) {
			UserAccount account = new UserAccount();
			BeanUtils.copyProperties(entity, account);
			accounts.add(account);
		}
		
		return accounts;
		
	}

}
