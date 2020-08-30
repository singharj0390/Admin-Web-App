package com.as.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Table(name = "user_account")
@Data
public class UserAccountEntity implements Serializable{

	private static final long serialVersionUID = 1L;

			@Id
             @Column(name = "user_Id")
			@GeneratedValue(strategy = GenerationType.IDENTITY)
	         private Integer userId;
             
             @Column(name = "first_name")
             private String firstName;
             
             @Column(name = "last_name")
             private String lastName;
             
             @Column(name = "email")
             private String email;
             
             @Column(name = "account_status")
             private String accStatus;
             
             @Column(name = "temp_password")
             private String tempPwd;
            
             @Column(name = "gender")
             private String gender;
             
             @Column(name = "role_id")
             private Integer roleId;
             
             
             @Column(name = "created_date", updatable = false)
             @CreationTimestamp
             @Temporal(TemporalType.DATE)
             private Date createdDate;
             
             @Column(name = "updated_date", insertable = false)
             @UpdateTimestamp
             @Temporal(TemporalType.DATE)
             private Date updatedDate;
             
             @Column(name = "switch_delete")
             private String switchDelete;
             
             
}
