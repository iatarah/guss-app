package org.ugguss.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.ugguss.model.Role;
import org.ugguss.model.User;

import java.util.Collection;

public interface IUserService {
    User registerUser(User user);
    User getUserByUserId(String userId);
    User getUserByEmail(String emailId);
    UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException;
    Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles);
}
