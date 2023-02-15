/**
 * 
 */
package com.beauto.iiotconnx.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	private String gstNo;
	private String pancard;
	private String dateReg;
	private String companyType;
	private String SubcriptionStatus;

}
