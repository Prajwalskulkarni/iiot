package com.beauto.iiotconnx.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.UserDeviceAssignModel;

@Repository
public interface UserDeviceRepo extends JpaRepository<UserDeviceAssignModel, Long> {
public List<UserDeviceAssignModel> getDevicesByuserId(int userId);

//@Transactional
//public void getuserBydevId(Long devId);

}
