package com.beauto.iiotconnx.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DeviceDeactivateRequestDto {
	
	private long deviceId;
	private String deviceStatus;

}
