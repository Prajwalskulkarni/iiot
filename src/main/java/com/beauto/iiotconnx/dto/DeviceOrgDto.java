package com.beauto.iiotconnx.dto;

import java.util.List;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class DeviceOrgDto {
  private List<DeviceOrganizationDto> deviceorgindto;
 private String companyName;

}
