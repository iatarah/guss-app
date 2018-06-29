package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.generated.model.UserRole;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IGussMemberServiceProvider;
import org.ugguss.service.IUserService;
import org.ugguss.service.serviceImpl.provider.UserServiceImplProvider;
import org.ugguss.util.constants.AppConstants;
import org.ugguss.service.serviceImpl.provider.ServiceImplProviderFactory;

import java.util.Collection;
import java.util.HashSet;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private ServiceImplProviderFactory serviceImplProviderFactory;
	@Autowired
	private IGussMemberServiceProvider iGussMemberServiceProvider;

    public UserServiceImpl() {
        super();
    }


	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest request) {

		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		if(request == null
				|| request.getAppUser() == null) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		UserServiceImplProvider provider = serviceImplProviderFactory.getServiceImplProvider(request.getAppUser().getUserRole());
		if(provider == null ) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User user = iUserRepository.findUserByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }
            org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(user));
            return userDetails;

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return null;
    }


    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().getRoleName());
        authorities.add(grantedAuthority);
        return authorities;
    }

    protected UserServiceImplProvider getServiceImplProvider(UserRole userRole) {
    	return serviceImplProviderFactory.getServiceImplProvider(userRole);
    }


	@Override
	public UserProfileResponse getUserByUserName(String userName) {
		return iGussMemberServiceProvider.getUserByUserName(userName);
	}

}
