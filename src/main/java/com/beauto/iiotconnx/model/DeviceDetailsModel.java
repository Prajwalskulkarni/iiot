package com.beauto.iiotconnx.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="device_details")
@Data
@ToString
public class DeviceDetailsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dev_id")
	private long devId;
	
	@Column(name="device_name")
	private String deviceName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="device_status")
	private String deviceStatus;
	
	@Column(name="manufact_id")
	private String manufactId;
	
	@Column(name="reg_date")
	private Date regiDate;
	
	@Column(name="updated_at")
	private Date updateAt;
	
	@Column(name="device_uiid")
	private String deviceUIID;
	@Column(name="deleted_Flag")
	private String deleted_Flag;
	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
//	Organization org;
	
	
	@OneToOne
	
	 @JoinColumn(name = "company_id") private Organization org;
	
	@Column(name="user_reg_date")
	private String userRegDate;
	
	
	
	
	
	
	
	

}
