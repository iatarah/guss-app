package org.ugguss.service.serviceImpl.provider;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.util.UserServiceMapperUtil;

public class AdminUserServiceImplProvider extends UserServiceImplProvider{
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;

	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		AppUser appUser = request.getAppUser();
		User user = userServiceMapperUtil.appUserToDbUser(appUser);
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
	
}
