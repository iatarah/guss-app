package org.ugguss.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.serviceImpl.UserDetailsServiceImpl;

import static org.ugguss.util.constants.RoleConstants.Constants.*;

@Configuration
@ComponentScan(basePackages = { "org.ugguss.*" })
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
/*    private static String REALM = "MY_TEST_REALM";

    @Autowired
    private IUserRepository userRepository;


    public SecurityConfig() {
        super();
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationMgr) throws Exception {
       authenticationMgr.userDetailsService(userDetailsServiceBean()).passwordEncoder(passwordEncoder());

        authenticationMgr.inMemoryAuthentication().withUser("john4@gmail.com").password("12345").roles("ADMIN");
        authenticationMgr.inMemoryAuthentication().withUser("hiab4@gmail.com").password("12345").roles("STAFF");

    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl(userRepository);
    	//return null;
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
                //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .antMatchers("/rest/ugguss/api/v1/login", "/rest/ugguss/api/v1/logout").permitAll()
                .antMatchers("/rest/ugguss/api/v1/protectedbyadmin").hasRole("ADMIN")
                .antMatchers("/rest/ugguss/api/v1/protectedbystaff").hasRole("STAFF")
                .antMatchers("/rest/ugguss/api/v1/profiles/1").permitAll()
                .antMatchers("/protectedbyrole").hasRole("GUSS_MEMBER")
                .antMatchers("/protectedforadmin").hasRole("ADMIN")
                .antMatchers("/protectedforstaff").hasRole("STAFF")
                .anyRequest().fullyAuthenticated()
                .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and().requestCache().requestCache(new NullRequestCache());
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
    }*/
    @Autowired
    private IUserRepository userRepository;
    
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl(userRepository);
    	//return null;
    }
    
/*	@Autowired
	@Qualifier(value="UserDetailsServiceImpl")
	private UserDetailsServiceImpl userDetailsServiceImpl;*/
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsServiceBean())
    		.passwordEncoder(noEncoder());
    }
   
    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
		// TODO Auto-generated method stub
    	return new JwtAuthenticationFilter();
	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable().cors()
    	.configurationSource(corsConfigurationSource()).and().addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
    	.authorizeRequests()
        .antMatchers("/rest/ugguss/api/v1/login", "/rest/ugguss/api/v1/logout").permitAll()
    	.antMatchers("/rest/ugguss/api/v1/token/auth", "/", "/resources/**", "/favicon.ico", "/main.js").permitAll()
    	.antMatchers("/css/**", "/js/**", "/images/**", "/styles.js", "/vendor.js", "/polyfills.js", "/runtime.js").permitAll()
    	.antMatchers(HttpMethod.GET, "/rest/ugguss/api/v1/profiles/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
    	.antMatchers(HttpMethod.POST, "/rest/ugguss/api/v1/profiles/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE)
    	.antMatchers(HttpMethod.GET, "/rest/ugguss/api/v1/userType").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
    	.antMatchers(HttpMethod.GET, "/rest/ugguss/api/v1/users/current").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
        .antMatchers(HttpMethod.POST, "/rest/ugguss/api/v1/registration/**").hasAnyRole(ADMIN_ROLE)
        .antMatchers(HttpMethod.POST, "/rest/ugguss/api/v1/member-profiles").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
        .antMatchers(HttpMethod.GET, "/rest/ugguss/api/v1/member-contribution/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
        .antMatchers(HttpMethod.PUT, "/rest/ugguss/api/v1/member-contribution/**").hasAnyRole(STAFF_ROLE, ADMIN_ROLE)
        .antMatchers(HttpMethod.POST, "/rest/ugguss/api/v1/member-contribution/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE)
        .antMatchers(HttpMethod.DELETE, "/rest/ugguss/api/v1/member-contribution/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE)
        .antMatchers(HttpMethod.POST, "/rest/ugguss/api/v1/member-benefits/**").hasAnyRole(ADMIN_ROLE, STAFF_ROLE)
        
        .antMatchers("/rest/ugguss/api/v1/protectedbyadmin").hasAnyRole(ADMIN_ROLE, STAFF_ROLE, MEMBER_ROLE)
        .antMatchers("/rest/ugguss/api/v1/protectedbystaff").hasRole(STAFF_ROLE)
        .antMatchers("/protectedbyrole").hasRole(MEMBER_ROLE)
        .antMatchers("/protectedforadmin").hasRole(ADMIN_ROLE)
        .antMatchers("/protectedforstaff").hasRole(STAFF_ROLE)
        .anyRequest().authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
     
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	web.ignoring()
    		.antMatchers("/resources/**")
    		.antMatchers("/favicon.ico");
    }
    
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
//            }
//        };
//    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
    	configuration.setAllowCredentials(true);
    	configuration.addAllowedOrigin("*");
    	configuration.addAllowedHeader("*");
    	configuration.addAllowedMethod("*");
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	source.registerCorsConfiguration("/**", configuration);
    	return source;
    }
    
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
    
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder noEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
    
    @Bean
    public BCryptPasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();
    }
    
    
}
