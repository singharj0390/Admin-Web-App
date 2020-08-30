package com.as.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.entities.UserAccountEntity;
import com.as.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable>{
         
	 public UserAccountEntity findAccountByTempPwd(String tempPassword); 
}
