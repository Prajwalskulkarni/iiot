package com.beauto.iiotconnx.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="user_device_assign")
public class UserDeviceAssignModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "user_device_assignid")
	private long userDeviceAssignId;
	
	private int userId;
	
	@OneToOne
	 @JoinColumn(name = "devId") private DeviceDetailsModel deviceModel;
	
	
	
}