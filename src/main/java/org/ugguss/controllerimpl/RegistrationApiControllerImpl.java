package org.ugguss.controllerimpl;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ugguss.generated.controller.RegistrationApi;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.service.IUserService;
import org.ugguss.util.constants.AppConstants;
import org.ugguss.util.constants.RestEndpointConstants;

import io.swagger.annotations.ApiParam;


@Controller
public class RegistrationApiControllerImpl implements RegistrationApi {
	private static final Logger LOG = LogManager.getLogger(RegistrationApiControllerImpl.class);
	@Autowired
	@Qualifier(value="userDetailsService")
	private IUserService iUserService;
	
	@Override
	@RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.REGISTER_USER,
	produces = { "application/json" }, 
	method = RequestMethod.POST)
	   public ResponseEntity<UserRegistrationResponse> registerUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		
		UserRegistrationResponse response = null;
		try {
			response = iUserService.registerUser(userRegistrationRequest);
		} catch (Exception e) {
			LOG.error("Exception in user registration", e.getCause());
			response = new UserRegistrationResponse().baseResponse(new BaseResponse());
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
		}
		
		return new ResponseEntity<UserRegistrationResponse>(response, HttpStatus.OK);
    }
}
