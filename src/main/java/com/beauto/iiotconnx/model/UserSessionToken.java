package com.beauto.iiotconnx.model;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_session_tokens")
public class UserSessionToken {

	@Id
	@GeneratedValue
	@Column(name = "user_session_token_id")	
	private int userSessionTokenId;

	  
	private int userId;
	
	@Column(name = "user_session_token")	  
	private String userSessionToken;
	
	@Column(name = "expires_on")	  
	private Date expiresOn;

	@Column(name = "expired")
	private Boolean expired;
	
	@Column(name = "created_on")	
	private Date createdOn;

	@Column(name = "updated_on")	
	private Date updatedOn;
	
	public UserSessionToken() {
		this.expired = Boolean.FALSE;
		Date now = new Date();
		this.createdOn = now;
		this.updatedOn = now;
		// added 7 days - TODO: the number of day should come from the configuration
		LocalDateTime plusDays = LocalDateTime.now().plusDays(7);
		this.expiresOn = Date.from(plusDays.toInstant(ZoneOffset.UTC));
	}
}