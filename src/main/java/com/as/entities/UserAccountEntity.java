package com.as.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;


@Entity
@Table(name = "User_Account")
@Data
public class UserAccountEntity implements Serializable{

	private static final long serialVersionUID = 1L;

			@Id
             @Column(name = "User_Id")
			@GeneratedValue
	         private Integer uId;
             
             @Column(name = "First_Name")
             private String userFirstName;
             
             @Column(name = "Last_Name")
             private String userLastName;
             
             @Column(name = "Email")
             private String userEmail;
             
             @Column(name = "Temp_Password")
             private String tempPassword;
             
             @Column(name = "Account_Status")
             private String accStatus;
             
             @Column(name = "Gender")
             private String gender;
             
             @Column(name = "Role_Id")
             private Integer roleId;
             
             @Column(name = "Created_Date")
             @CreationTimestamp
             @Temporal(TemporalType.DATE)
             private Date createdDate;
             
             @Column(name = "Updated_Date")
             @UpdateTimestamp
             @Temporal(TemporalType.DATE)
             private Date updatedDate;
             
             
}
