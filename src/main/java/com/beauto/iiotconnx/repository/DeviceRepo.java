package com.beauto.iiotconnx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.DeviceDetailsModel;

@Repository
public interface DeviceRepo extends JpaRepository<DeviceDetailsModel, Long>{

}
