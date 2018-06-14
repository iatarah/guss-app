package org.ugguss.service;

import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.ugguss.model.Role;
import org.ugguss.model.User;

import java.util.Collection;

public interface IUserService {
	UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
    User getUserByUserId(String userId);
    User getUserByEmail(String emailId);
    UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException;
    Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles);
}
