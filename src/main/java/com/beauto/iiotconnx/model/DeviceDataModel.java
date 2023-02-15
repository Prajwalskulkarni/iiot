/**
 * 
 */
package com.beauto.iiotconnx.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import lombok.Data;
import lombok.ToString;

/**
 * @author Abhijit jadhav
 * @date - 12/01/2023
 */

@Data
@ToString
@Entity
@Table(name = "devicedata")
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public class DeviceDataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long dataId;

	@Type(type = "jsonb")
	@Column(name="data",columnDefinition = "jsonb")
	private String data;
	
	@Column(name="device_uuid")
	private String deviceUUID;
	
	@Column(name="data_added_date")
	private Date dataAddedDate;

}
