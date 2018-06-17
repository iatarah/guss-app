package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.Role;

import java.util.Collection;

@Component
@Qualifier(value="MemberUserServiceImplProvider")
public class MemberUserServiceImplProvider extends UserServiceImplProvider{

	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
		// TODO Auto-generated method stub
		return null;
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
