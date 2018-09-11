package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;

import java.util.HashSet;
import java.util.Set;

@Transactional
@Qualifier(value = "UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserRepository iUserRepository;

    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.iUserRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = iUserRepository.findUserByEmail(username);
            System.out.println(user);
            System.out.println("Spring Security called by" + user);
            if (user == null) {
                throw new UsernameNotFoundException("No user found with username: " + username);
            }
            org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true, getAuthorities(user));
            return userDetails;

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().getRoleName());
        System.out.println(grantedAuthority.getAuthority() + " " + "wasup");
        System.out.println(user.getRole().getRoleName());
        authorities.add(grantedAuthority);

        return authorities;
    }
}
