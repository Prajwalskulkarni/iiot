package com.beauto.iiotconnx.dto;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDevices {
	private int userId;
	private List<UserDevice> userDevice;

}