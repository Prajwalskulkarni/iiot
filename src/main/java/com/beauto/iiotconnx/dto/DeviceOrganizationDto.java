package com.beauto.iiotconnx.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class DeviceOrganizationDto {
	
	private String deviceName;
	private String deviceId;

	private String productName;

	private String deviceStatus;

	private String manufactId;

	private Date regiDate;

	private Date updateAt;

	private String deviceUIID;
	private String companyName;
}
