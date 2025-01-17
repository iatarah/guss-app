package org.ugguss.config;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.serviceImpl.UserDetailsServiceImpl;
import org.ugguss.service.serviceImpl.UserServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

import static org.ugguss.util.constants.SecurityConstants.HEADER_STRING;
import static org.ugguss.util.constants.SecurityConstants.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
	private static final Logger LOG = LogManager.getLogger(JwtAuthenticationFilter.class);
/*	@Autowired
	@Qualifier("UserDetailsServiceImpl")
	private UserDetailsServiceImpl userDetailsServiceImpl;*/
	
    @Autowired
    private IUserRepository userRepository;
    
    
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl(userRepository);
    	//return null;
    }
	
	@Autowired
	private TokenProvider jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain ) throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);
		String username = null;
		String authToken = null;
		if (header != null && header.startsWith(TOKEN_PREFIX)) {
			authToken = header.replaceAll(TOKEN_PREFIX, "");
			try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
			} catch (IllegalArgumentException e) {
                logger.error("an error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("the token is expired and not valid anymore", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
		} else {
	           logger.warn("couldn't find bearer string, will ignore the header");
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = null;
			try {
				userDetails = userDetailsServiceBean().loadUserByUsername(username);
			} catch (UsernameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                logger.info("authenticated user " + username + ", setting security context");
                SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		
		chain.doFilter(req, res);
	}
	
}