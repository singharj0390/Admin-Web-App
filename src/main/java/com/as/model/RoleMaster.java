package com.as.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class RoleMaster implements Serializable {


	private static final long serialVersionUID = 1L;
        
	   private Integer roleId;
	   private String role;
}
