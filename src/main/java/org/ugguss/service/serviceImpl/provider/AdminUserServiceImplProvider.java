package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IRoleService;
import org.ugguss.util.RegistrationUtil;
import org.ugguss.util.UserServiceMapperUtil;
import org.ugguss.util.constants.AppConstants;

import java.util.Collection;
import java.util.Date;
@Component
@Qualifier(value="AdminUserServiceImplProvider")
public class AdminUserServiceImplProvider extends UserServiceImplProvider{
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;
	@Autowired
	private IRoleService iRoleService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		AppUser appUser = userRegistrationRequest.getAppUser();
		User user = userServiceMapperUtil.appUserToDbUser(appUser);
		Role role = iRoleService.getRoleByRoleName(AppConstants.ADMIN);

		if(user == null || role == null) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
		}

		// Encode the password for Security Purpose
/*		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));*/
		RegistrationUtil.populateUserExtraAttributes(userRegistrationRequest, role, user);
		
		try {
			User savedUser =  iUserRepository.save(user);
			AppUser dtoUser = userServiceMapperUtil.dbUserToAppUser(savedUser);
			response.setAppUser(dtoUser);
			response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);		
			
		} catch (Exception e) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			e.printStackTrace(); // TODO: handle exception
		}
		return response;
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		return null;
	}

	@Override
	public UserProfileResponse getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
