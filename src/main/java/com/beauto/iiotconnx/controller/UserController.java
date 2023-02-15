package com.beauto.iiotconnx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.beauto.iiotconnx.dto.InviteLinkVerification;
import com.beauto.iiotconnx.dto.LoginRequestDto;
import com.beauto.iiotconnx.dto.LoginResponseDto;
import com.beauto.iiotconnx.dto.OrganizationUserDto;
import com.beauto.iiotconnx.dto.PasswordUpdateDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDeviceFlagDto;
import com.beauto.iiotconnx.dto.UserDto;
import com.beauto.iiotconnx.model.User;
import com.beauto.iiotconnx.repository.UserRepository;
import com.beauto.iiotconnx.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping(value = "/login")
	public LoginResponseDto userLogin(@RequestBody LoginRequestDto request) {

		User user = new User();
		user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
		System.out.println("user" + user);
		LoginResponseDto response = new LoginResponseDto();
		
		System.out.println("request" + request);
		if (user != null) {
			response.setCode("200");
			response.setMeassage("Login successfully!!");
			response.setRoleId(user.getUseRoleId());
			response.setId(user.getId());
			response.setCompanyId(user.getCompanyId());
			response.setUsername(user.getFirstName() +" "+ user.getLastName());
			
		} else {
			response.setCode("500");
			response.setMeassage("Username Not Found!!");
		}
		return response;
	}
//     @sentrySpan
	@PostMapping("saveUsers")
	public StatusDto saveUser(@RequestBody UserDto users) {
		log.info("Executing :: UserController.saveUser(UserDto users)");

		if (null == users.getFirstName() || users.getFirstName().equalsIgnoreCase("")) {
			StatusDto response = new StatusDto();
			response.setCode("300");
			response.setMessage("first name should not be null");

			return response;
		}if(users.getId()==0) {
			StatusDto response = userService.saveUser(users);
			return response;
		}
		else {
			StatusDto response = userService.updateUser(users);
			return response;
	}
}

	
	@PostMapping("/getAllUsers")
	public List<UserDeviceFlagDto> getAllUsers() {
		log.info("Executing :: UserController.getAllUsers()");
		List<UserDeviceFlagDto> users=	userService.getAllUsers();
		return users;
	}
	@GetMapping("/findUserByCompanyid/{CompanyId}")
	public List<OrganizationUserDto> findByEmailId(@PathVariable("CompanyId") int CompanyId) {
		log.info("Executing :: UserController.finfByEmaiId(int CompanyId)" + CompanyId);

		List<OrganizationUserDto> user = userService.findAllUsersByCompanyId(CompanyId);
		return user;
	}
	@PostMapping("/updatepassword")

	public StatusDto updateDepartment(@RequestBody PasswordUpdateDto passwordDto) {
		System.out.println(passwordDto.toString());
		User user =new User();
		StatusDto response = new StatusDto();
		if (passwordDto.getPassword().equalsIgnoreCase(passwordDto.getConfirmPassword())) {
			userService.updatePassword(passwordDto);
			response.setCode("200");
			response.setMessage("password updated");
//			user.setRegistration_Status("true");
			
		} else {
			response.setCode("500");
			response.setMessage("password Not Set");
		}

		return response;
	}

	@DeleteMapping("/delete/{id}")
	public StatusDto deleteByUserId(@PathVariable("id") int id) {
		log.info("Executing :: UserController.deleteByUserId(int id)" + id);

		userService.deleteById(id);
		StatusDto response = new StatusDto();
		response.setCode("200");
		response.setMessage("delete sucessfully");
		return response;

	}

	@GetMapping("/getbyId/{id}")
	public User getByUserId(@PathVariable("id") int id) {

		log.info("Executing :: UserController.getByUserId(int id)" + id);

		return userService.getUserById(id);

	}

	@GetMapping("/findByEmailId/{email}")
	public List<User> findByEmailId(@PathVariable("email") String email) {
		log.info("Executing :: UserController.finfByEmaiId(String email)" + email);

		List<User> user1 = userService.getByEmailId(email);
		return user1;

	}

	/*
	 * @GetMapping("/getAllDeviceById/{id}") public List<DeviceDetailsModel>
	 * getAllDivicesById(@PathVariable int id) {
	 * log.info("Executing :: UserController.getAllDevicesById(int id)"+id);
	 * 
	 * List<DeviceDetailsModel> listdevices = userService.getAllDivicesById(id);
	 * return listdevices;
	 * 
	 * }
	 */
	@GetMapping("/getUUID/{userId}")
	public InviteLinkVerification getUid(@PathVariable("userId") String userId) {
		log.info("Executing :: UserController.getUid(String userId)" + userId);

		InviteLinkVerification response = new InviteLinkVerification();
		StatusDto responseVe = new StatusDto();
		responseVe.setCode("200");
		responseVe.setMessage("password screen");
		response.setUUID(userId);
		response.setResponse(responseVe);
		return response;
	}
	 @GetMapping("/resendlink/{id}")
	 public StatusDto resendEmailLink(@PathVariable("id") int id) {
		 StatusDto response=new StatusDto();
		 User user=new User();
		 user=userRepository.getUserById(id);
		 if(user.getPassword()==null) {
				userService.resendLink(id);
				response.setCode("200");
				response.setMessage("password link send successfully");
			}
			else {
				response.setCode("500");
				response.setMessage("User already registered");
			}
			
			return response;
		}
	 

}
