package com.as.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAccount implements Serializable{
          
	private static final long serialVersionUID = 1L;
	
			private Integer userId;
	        private String firstName;
	        private String lastName;
	        private String email;
	        private String accStatus;
	        private String tempPassword;
	        private String gender;
	        private Integer roleId;
	        private Date createdDate;
	        private Date updatedDate;
	        private String switchDelete;
}
