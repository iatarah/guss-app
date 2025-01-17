package org.ugguss.controllerimpl;

import io.swagger.annotations.ApiParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ugguss.generated.controller.ProfilesApi;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.service.IUserService;
import org.ugguss.util.constants.RestEndpointConstants;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-31T21:30:34.195-04:00")

@Controller
public class ProfilesApiController implements ProfilesApi {
	private static final Logger LOG = LogManager.getLogger(ProfilesApiController.class);
	
	@Autowired
	@Qualifier(value="userDetailsService")
    private IUserService iUserService;

    @CrossOrigin(origins="*")
    @Override
    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.GET_MEMBER_PROFILE,
    produces = { "application/json" }, 
    method = RequestMethod.GET)
    public ResponseEntity<UserProfileResponse> getMember(@ApiParam(value = "",required=true ) @PathVariable("userName") String userName) {
    	LOG.debug("Calling profile api with userName: {}", userName);
    	UserProfileResponse response = iUserService.getUserByUserName(userName);
        return new ResponseEntity<UserProfileResponse>(response, HttpStatus.OK);
    }
    
}
