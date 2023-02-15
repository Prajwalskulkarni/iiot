package com.beauto.iiotconnx.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
public class DeviceResponseDto<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String responseCode;
	private String responseMessage;
	private Exception exception;
	private OutputDto<T> result;

}
