package com.as.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.entities.UserAccountEntity;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable>{

}
