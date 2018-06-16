package org.ugguss.service.serviceImpl.provider;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IRoleService;
import org.ugguss.util.UserServiceMapperUtil;

import java.util.Collection;
@Component
@Qualifier(value="AdminUserServiceImplProvider")
public class AdminUserServiceImplProvider extends UserServiceImplProvider{
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;
	@Autowired
	private IRoleService iRoleService;

	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		AppUser appUser = request.getAppUser();
		User user = userServiceMapperUtil.appUserToDbUser(appUser);
		user.setPassword("password1");
		Role role = iRoleService.getRoleByRoleName("ADMIN");
		
		role.setRoleName("ADMIN");
		role.setId(role.getId());
		user.setRole(role);
		try {
			User savedUser =  iUserRepository.save(user);
			AppUser dtoUser = userServiceMapperUtil.dbUserToAppUser(savedUser);
			response.setAppUser(dtoUser);
			response.getBaseResponse().setReturnCode(0);		
			
		} catch (Exception e) {
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

}
