package org.ugguss.controllerimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ugguss.generated.controller.RegistrationApi;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.service.IUserService;
import org.ugguss.util.constants.RestEndpointConstants;

import io.swagger.annotations.ApiParam;


@Controller
public class RegistrationApiControllerImpl implements RegistrationApi {
	@Autowired
	private IUserService iUserService;
	
	@Override
	@RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.REGISTER_USER,
	produces = { "application/json" }, 
	method = RequestMethod.POST)
	   public ResponseEntity<UserRegistrationResponse> registerUser(@ApiParam(value = "" ,required=true )  @Valid @RequestBody UserRegistrationRequest userRegistrationRequest) {
		UserRegistrationResponse response = iUserService.registerUser(userRegistrationRequest);
		return new ResponseEntity<UserRegistrationResponse>(response, HttpStatus.OK);
    }
}
