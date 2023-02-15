package com.beauto.iiotconnx.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;

/**
 * @author Abhijit jadhav
 *
 */


public class DeviceDetailRequestDto {

	

	private long devId;
	
	private String deviceName;
	
	private String productName;

	private String deviceStatus;
	
	private String manufactId;

	private String regiDate;

	private Date updateAt;
	private String deviceUIID;
	
	public String getDeviceUIID() {
		return deviceUIID;
	}

	public void setDeviceUIID(String deviceUIID) {
		this.deviceUIID = deviceUIID;
	}

	private String userId;
	
	private String companyId;
	public long getDevId() {
		return devId;
	}

	public void setDevId(long devId) {
		this.devId = devId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getManufactId() {
		return manufactId;
	}

	public void setManufactId(String manufactId) {
		this.manufactId = manufactId;
	}

	public String getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "DeviceDetailRequestDto [devId=" + devId + ", deviceName=" + deviceName + ", productName=" + productName
				+ ", deviceStatus=" + deviceStatus + ", manufactId=" + manufactId + ", regiDate=" + regiDate
				+ ", updateAt=" + updateAt + ", deviceUIID=" + deviceUIID + ", userId=" + userId + ", companyId="
				+ companyId + "]";
	}

	

}
