package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.UserRegistrationRequest;
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
    public User registerUser(AppUser user) {
    	UserServiceImplProvider provider = serviceImplProviderFactory.getServiceImplProvider(user.getUserRole());
    	return provider.registerUser(user);        
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
