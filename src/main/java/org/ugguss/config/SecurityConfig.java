package org.ugguss.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IUserService;
import org.ugguss.service.serviceImpl.UserDetailsServiceImpl;

@Configuration
@ComponentScan(basePackages = { "org.ugguss.*" })
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static String REALM = "MY_TEST_REALM";

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    public SecurityConfig() {
        super();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationMgr) throws Exception {
       authenticationMgr.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());
/*        authenticationMgr.inMemoryAuthentication().withUser("john4@gmail.com").password("12345").roles("ADMIN");
        authenticationMgr.inMemoryAuthentication().withUser("hiab4@gmail.com").password("12345").roles("STAFF");*/
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl(userRepository);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/rest/ugguss/api/v1/login", "/rest/ugguss/api/v1/logout").permitAll()
                .antMatchers("/rest/ugguss/api/v1/protectedbyadmin").hasRole("ADMIN")
                .antMatchers("/rest/ugguss/api/v1/protectedbystaff").hasRole("STAFF")
                .antMatchers("/rest/ugguss/api/v1/profiles/1").permitAll()
                .antMatchers("/protectedbyrole").hasRole("GUSS_MEMBER")
                .antMatchers("/protectedforadmin").hasRole("ADMIN")
                .antMatchers("/protectedforstaff").hasRole("STAFF")
                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                //.anyRequest().authenticated();
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
        return new CustomBasicAuthenticationEntryPoint();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
