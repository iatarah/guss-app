package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IUserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;

    public UserServiceImpl() {
        super();
    }


    @Override
    public User registerUser(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public User getUserByUserId(String userId) {
        return iUserRepository.findUserByUserId(userId);
    }

    @Override
    public User getUserByEmail(String emailId) {
        return iUserRepository.findUserByEmail(emailId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            User user = iUserRepository.findUserByEmail(email);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + email);
            }
            org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, getAuthorities(null));
            return userDetails;

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return null;
    }
}
