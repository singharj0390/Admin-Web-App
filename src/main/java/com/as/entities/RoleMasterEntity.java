package com.as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Role_Master")
@Data
public class RoleMasterEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;
          
	     @Id
	     @Column(name = "Role_Id")
	     private Integer roleId;
	     
	     @Column(name = "Role")
	     private String role; 
}
