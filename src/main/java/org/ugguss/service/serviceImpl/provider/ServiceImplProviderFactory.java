package org.ugguss.service.serviceImpl.provider;

import org.springframework.stereotype.Component;
import org.ugguss.generated.model.UserRole;

@Component
public class ServiceImplProviderFactory {
	
	public UserServiceImplProvider getServiceImplProvider (UserRole role){
		
		UserServiceImplProvider provider = null;
		if(role == null) {
			// TODO : add log here indicating user type can't be null
			return null;
		}
		switch (role) {
		case ADMIN: 
			provider = new AdminUserServiceImplProvider();
		case STAFF:
			provider = new StaffUserServiceImplProvider();
		case MEMBER:
			provider = new MemberUserServiceImplProvider();
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
}
