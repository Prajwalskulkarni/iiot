package com.beauto.iiotconnx.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InviteLinkVerification {
	private StatusDto response;
	private String UUID;
}

