package com.as.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
		entity.setUserFirstName(userAcc.getFirstName());
		entity.setUserLastName(userAcc.getLastName());
		entity.setUserEmail(userAcc.getEmail());
		entity.setTempPassword(userAcc.getTempPassword());
		entity.setAccStatus(userAcc.getAccStatus());
		entity.setGender(userAcc.getGender());
		entity.setRoleId(userAcc.getRoleId());
		
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

}
