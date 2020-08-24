package com.as.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAccount implements Serializable{
          
	        private Integer userId;
	        private String firstName;
	        private String lastName;
	        private String email;
	        private String accStatus;
	        private String tempPassword;
	        private String gender;
	        private Integer roleId;
}
