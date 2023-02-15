package com.beauto.iiotconnx.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;

	 @Column(name = "uId")
	private String uId;

	@Column(name = "USER_FIRST_NAME")
	private String firstName;

	@Column(name = "USER_LAST_NAME")
	private String lastName;

	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	@CreatedDate
	@Column(name = "UPDATED_ON")
	private Date updatedOn;

	@Column(name = "USER_DELETED_FLAG")
	private Boolean userdeletedflag;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "user_role_id")
	private String useRoleId;

	@Column(name = "COMPANY_Id")
	private int companyId;

	@Column(name = "COMPANY_Name")
	private String companyName;
	@Column (name="Registration_Status")
	private String registration_Status;
	/*
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_id", referencedColumnName = "USER_ID")
	private List<DeviceDetailsModel> devices;
*/
}
