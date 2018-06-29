package org.ugguss.service.serviceImpl.provider;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.generated.model.UserRole;
import org.ugguss.model.Role;

@Component
public class ServiceImplProviderFactory {
	@Autowired
	@Qualifier(value="AdminUserServiceImplProvider")
	private AdminUserServiceImplProvider adminUserServiceImplProvider;
	@Autowired
	@Qualifier(value="MemberUserServiceImplProvider")
	private MemberUserServiceImplProvider memberUserServiceImplProvider;
	@Autowired
	@Qualifier(value="StaffUserServiceImplProvider")
	private StaffUserServiceImplProvider  staffUserServiceImplProvider;
	@Qualifier(value="UserServiceImplProvider")
	private UserServiceImplProvider  userServiceImplProvider;
	
	
	public UserServiceImplProvider getServiceImplProvider (UserRole role){
		
		UserServiceImplProvider provider = null;
		if(role == null) {
			// TODO : add log here indicating user type can't be null
			return null;
		}
		switch (role) {
		case ADMIN: 
			provider = adminUserServiceImplProvider;
			break;
		case STAFF:
			provider = staffUserServiceImplProvider;
			break;
		case MEMBER:
			provider = memberUserServiceImplProvider;
			break;
		default:
			provider = null;
		}
		return provider;
		
	}
	
	protected UserServiceImplProvider serviceImplProvider (int userId) throws Exception{
		
		UserServiceImplProvider provider = null;
		return null;
		// TODO: Implement for userId option
		
	}
	
	public UserServiceImplProvider getUserServiceImplProvider () throws Exception{
		return memberUserServiceImplProvider; 
	}	

}
