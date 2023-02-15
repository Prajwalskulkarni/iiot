package com.beauto.iiotconnx.serviceImpl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.beauto.iiotconnx.dto.LoginRequestDto;
import com.beauto.iiotconnx.dto.OrganizationUserDto;
import com.beauto.iiotconnx.dto.PasswordUpdateDto;
import com.beauto.iiotconnx.dto.StatusDto;
import com.beauto.iiotconnx.dto.UserDeviceFlagDto;
import com.beauto.iiotconnx.dto.UserDto;
import com.beauto.iiotconnx.model.User;
import com.beauto.iiotconnx.model.UserDeviceAssignModel;
import com.beauto.iiotconnx.repository.DeviceDetailsRepo;
import com.beauto.iiotconnx.repository.UserDeviceRepo;
import com.beauto.iiotconnx.repository.UserRepository;
import com.beauto.iiotconnx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userReposatory;
	@Autowired
	DeviceDetailsRepo devicerepo;
	
	@Autowired
	UserDeviceRepo userDeviceRepo;

	@Autowired
	EmailService emailService;

	@Value("${email.url}") 
    private String emailUrl;
	
	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public void loginCheck(String email, String password) {
		// TODO Auto-generated method stub
		User user = new User();

		user = userReposatory.findByEmailAndPassword(email, password);
		
       System.out.println(user);
		LoginRequestDto request = new LoginRequestDto();

		if (user != null) {
			request.setEmail(user.getEmail());
			request.setPassword(user.getPassword());
		}
	}

	public StatusDto saveUser(UserDto user) {
		
		User model = userReposatory.findByEmail(user.getEmail());
		StatusDto response = new StatusDto();

		if (model != null) {
			response.setCode("500");
			response.setMessage("this emailid alredy existed");
			return response;
		} else {
			model = new User();

			String uId = UUID.randomUUID().toString();
			model.setUId(uId);
			model.setFirstName(user.getFirstName());
			model.setLastName(user.getLastName());
			model.setPhoneNumber(user.getPhoneNumber());
			model.setEmail(user.getEmail());
			model.setCreatedOn(new Date());
			model.setRegistration_Status("false");
			model.setPassword(user.getPassword());
			model.setUseRoleId(user.getUseRoleId());
			model.setCompanyId(user.getCompanyId());
			model.setCompanyName(user.getCompanyName());

			User saved = userReposatory.save(model);
			System.out.println(user.toString());
			if (saved != null) {

				SimpleMailMessage mailMessage = new SimpleMailMessage();
				mailMessage.setFrom(sender);
				mailMessage.setTo(user.getEmail());
				mailMessage.setSubject(" Registration Successful!!");
				mailMessage.setText("Welcome To Beauto System, please click here To generate Password: "
						+ emailUrl + saved.getId());
				

				emailService.sendEmail(mailMessage);

				response.setCode("200");
				response.setMessage("Success");
			}
			return response;
		}
	}
	
	public StatusDto updateUser(UserDto userDto) {
		
		StatusDto response = new StatusDto();
		User user =userReposatory.getUserById(userDto.getId());
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setCreatedOn(user.getCreatedOn());
		user.setUpdatedOn(new Date());
		user.setUseRoleId(userDto.getUseRoleId());
		user.setCompanyId(userDto.getCompanyId());
		user.setCompanyName(userDto.getCompanyName());
		user.setRegistration_Status(user.getRegistration_Status());
		
			userReposatory.save(user);
			response.setCode("200");
			response.setMessage("updated successfully");	
		
		return response;
		
	}

	public List<UserDeviceFlagDto> getAllUsers() {
		UserDeviceFlagDto userflag = null;
		List<UserDeviceFlagDto> usd = new ArrayList<UserDeviceFlagDto>();

		List<User> users = userReposatory.findAll();

		for (User us : users) {
			userflag = new UserDeviceFlagDto();
			userflag.setId(us.getId());
			userflag.setCompanyId(us.getCompanyId());
			userflag.setFirstName(us.getFirstName());
			userflag.setLastName(us.getLastName());
			userflag.setEmail(us.getEmail());
			userflag.setPhoneNumber(us.getPhoneNumber());
			userflag.setUId(us.getUId());
			userflag.setPassword(us.getPassword());
			userflag.setRegistration_Status(us.getRegistration_Status());
			userflag.setCompanyName(us.getCompanyName());
			userflag.setUseRoleId(us.getUseRoleId());
			List<UserDeviceAssignModel> udm = userDeviceRepo.getDevicesByuserId(us.getId());
			if (udm.size() > 0) {
				userflag.setFlag("true");
			} else {
				userflag.setFlag("false");
			}
			usd.add(userflag);

		}

		return usd;
	}
	
	

	public void updatePassword(PasswordUpdateDto passwordDto) {
		User user = userReposatory.getUserById(passwordDto.getId());
		user.setPassword(passwordDto.getPassword());
		user.setRegistration_Status("true");
		userReposatory.save(user);


	}

	public User getUserById(int id) {
		StatusDto response = new StatusDto();
		User model = new User();

		if (model.getId() == 0) {

			response.setCode("400");
			response.setMessage("user id is not there");
		}

		return userReposatory.getUserById(id);
	}

	public void deleteById(int id) {

		if (id == 0) {
			StatusDto response = new StatusDto();

			response.setCode("400");
			response.setMessage("user id is not there");
		}

		userReposatory.deleteById(id);
	}

	public List<User> getByEmailId(String email) {
		List<User> user1 = userReposatory.getByEmail(email);
		return user1;
	}

	@Override
	public List<OrganizationUserDto> findAllUsersByCompanyId(int companyId) {
		OrganizationUserDto organizationUserDto=null;
		List<OrganizationUserDto>organizationUserdto=new ArrayList<OrganizationUserDto>();
		List<User> user = userReposatory.findAllUsersByCompanyId(companyId);
		for(User u:user) {
			organizationUserDto = new OrganizationUserDto();
			organizationUserDto.setId(u.getId());
			organizationUserDto.setCompanyId(u.getCompanyId());
			organizationUserDto.setFirstName(u.getFirstName());
			organizationUserDto.setLastName(u.getLastName());
			organizationUserDto.setEmail(u.getEmail());
			organizationUserDto.setPhoneNumber(u.getPhoneNumber());
			organizationUserDto.setUId(u.getUId());
			organizationUserDto.setRegistration_Status(u.getRegistration_Status());
			organizationUserDto.setCompanyName(u.getCompanyName());
			organizationUserDto.setUseRoleId(u.getUseRoleId());
			List<UserDeviceAssignModel> udm = userDeviceRepo.getDevicesByuserId(u.getId());
			if (udm.size() > 0) {
				organizationUserDto.setFlag("true");
			} else {
				organizationUserDto.setFlag("false");
			}
			organizationUserdto.add(organizationUserDto);

		}

		return organizationUserdto;
	}

	@Override
	public void resendLink(int id) {
		User user = new User();
		user = userReposatory.getUserById(id);
		if(user.getPassword()==null) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(user.getEmail());
			mailMessage.setSubject(" Registration Successful!!");
			mailMessage.setText("Welcome To Beauto System, please click here To generate Password: "
					+ emailUrl + user.getId());
			emailService.sendEmail(mailMessage);
	}
		

	/*
	 * public List<DeviceDetailsModel> getAllDivicesById(int id) {
	 * 
	 * return devicerepo.findAll(); }
	 */

}}
