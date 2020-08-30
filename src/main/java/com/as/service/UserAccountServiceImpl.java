package com.as.service;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.as.constants.AppConstants;
import com.as.entities.RoleMasterEntity;
import com.as.entities.UserAccountEntity;
import com.as.model.RoleMaster;
import com.as.model.UnlockAccount;
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
		userAcc.setTempPwd(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		userAcc.setAccStatus(AppConstants.LOCKED_STR);
		if(userAcc.getUserId()==null) {
			userAcc.setSwitchDelete("Y");
		}
		
		UserAccountEntity entity = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, entity);
		
	UserAccountEntity savedEntity =  uAccRepo.save(entity);
	if(savedEntity.getUserId()!=null) {
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

	@Override
	public UserAccount getAccountById(Integer id) {
		Optional<UserAccountEntity> findById = uAccRepo.findById(id);
		if(findById.isPresent()) {
			UserAccountEntity entity = findById.get();
			UserAccount account = new UserAccount();
			BeanUtils.copyProperties(entity, account);
			return account;
		}
		return null;
	}

	@Override
	public RoleMaster getRoleById(Integer roleId) {
		Optional<RoleMasterEntity> findById = roleRepo.findById(roleId);
		if(findById.isPresent()) {
			RoleMasterEntity entity = findById.get();
			RoleMaster role = new RoleMaster();
			BeanUtils.copyProperties(entity, role);
			return role;
		}
		return null;
	}

	@Override
	public boolean deleteAccount(Integer id) {
		
		return false;
	}

	@Override
	public boolean updateAccount(UserAccount account) {
		UserAccountEntity entity = new UserAccountEntity();
		
		BeanUtils.copyProperties(account, entity);
	UserAccountEntity savedEntity =  uAccRepo.save(entity);
	if (savedEntity!=null) {
		return savedEntity.getUserId()!=null;
	}
		return false;
	}

	@Override
	public boolean updateTempPassword(UnlockAccount unlockAcc) {
		
		return false;
	}

	
	  @Override 
	  public UserAccount getAccountByTempPwd(String tempPwd) {
		  UserAccountEntity entity = uAccRepo.findAccountByTempPwd(tempPwd);
		  if (entity!=null) {
			  UserAccount account = new UserAccount();
			  BeanUtils.copyProperties(entity, account);
			  return account;
		}
	  return null; 
	  }
	 

	/*
	 * @Override public boolean deleteAccount(Integer id) { if(id!=null) {
	 * uAccRepo.deleteById(id); return true; } return false; }
	 */
	
	
	
	

}
