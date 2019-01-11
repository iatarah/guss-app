package org.ugguss.controllerimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ugguss.config.JwtTokenUtil;
import org.ugguss.generated.controller.TokenApi;
import org.ugguss.generated.model.AuthToken;
import org.ugguss.generated.model.LoginRequest;
import org.ugguss.model.User;
import org.ugguss.service.IUserService;
import org.ugguss.util.UserServiceMapperUtil;
import org.ugguss.util.constants.RestEndpointConstants;

import io.swagger.annotations.ApiParam;

@RestController
//@RequestMapping("/token")
public class AuthenticationController implements TokenApi {
    @Autowired
    @Qualifier(value="userDetailsService")
    private IUserService userService;
    
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;
	
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @CrossOrigin(origins="*")
    @Override
    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API + "/" + RestEndpointConstants.Constants.AUTH,
    				produces = { "application/json" }, method = RequestMethod.POST)
    public ResponseEntity<AuthToken> authenticate(@ApiParam(value = "" ,required=true) @Valid @RequestBody LoginRequest loginRequest) {
    	final Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
    	SecurityContextHolder.getContext().setAuthentication(authentication);
    	final User user = userService.getUserByEmail(loginRequest.getEmail());
    	final String token = jwtTokenUtil.generateToken(user);
    	
    	AuthToken tk = new AuthToken();
    	tk.setToken(token);
    	if(authentication.isAuthenticated()) {
    		tk.setAppUser(userServiceMapperUtil.dbUserToAppUser(user));
    	}
    	return new ResponseEntity<AuthToken>(tk, HttpStatus.OK);
    	//return ResponseEntity.ok(new AuthToken(token));
    }
    
}
