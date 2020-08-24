package com.as.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.entities.RoleMasterEntity;

public interface RoleRepository extends JpaRepository<RoleMasterEntity, Serializable> {

}
