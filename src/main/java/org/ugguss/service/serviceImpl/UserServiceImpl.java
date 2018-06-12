package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.generated.model.UserRole;
import org.ugguss.generated.model.UserType;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IUserService;
import org.ugguss.service.serviceImpl.provider.UserServiceImplProvider;
import org.ugguss.service.serviceImpl.provider.ServiceImplProviderFactory;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private ServiceImplProviderFactory serviceImplProviderFactory;


	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest request) {
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		if(request == null
				|| request.getAppUser() == null) {
			response.getBaseResponse().setReturnCode(1);
			return response;
		}
		UserServiceImplProvider provider = serviceImplProviderFactory.getServiceImplProvider(request.getAppUser().getUserRole());
		if(provider == null ) {
			response.getBaseResponse().setReturnCode(1);
			return response;
		}
		return provider.registerUser(request);
	}
	
    @Override
    public User getUserByUserId(String userId) {
        return iUserRepository.findUserByUserId(userId);
    }

    @Override
    public User getUserByEmail(String emailId) {
    	UserRegistrationRequest ur = new UserRegistrationRequest();
    	ur.getMember();
        return iUserRepository.findUserByEmail(emailId);
    }
    
    protected UserServiceImplProvider getServiceImplProvider(UserRole userRole) {
    	return serviceImplProviderFactory.getServiceImplProvider(userRole);
    }

}
