
package com.beauto.iiotconnx.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beauto.iiotconnx.model.DeviceDataModel;

/**
 * @author Abhijit Jadhav
 * @date 13/01/2023
 */
@Repository
public interface DeviceDataRepo extends JpaRepository<DeviceDataModel, Long> {
	
	@Modifying
	@Query(value="INSERT INTO devicedata(data, device_uuid) VALUES (:request,:uuid)", nativeQuery = true)
	void saveDeviceData(@Param("request") String request, @Param("uuid") String uuid);
	
	
	
	@Modifying
	@Query(value="select jsonb_object_keys(data) from devicedata where device_uuid=:device_uuid", nativeQuery = true)
	Set<String> getDeviceKeys(@Param("device_uuid") String device_uuid);
	
	;
	@Modifying
	@Query(value="SELECT data->>:key FROM devicedata where device_uuid=:device_uuid", nativeQuery = true)
	//@Query(value="select data_id,data_added_date, data->>:key from devicedata where device_uuid=:device_uuid", nativeQuery = true)
	List<String> getDeviceData(@Param("key") String key,@Param("device_uuid") String device_uuid);
	
	List<DeviceDataModel> findByDeviceUUID(String deviceUUID);
	
	
	
	
	
	

	
	
}
