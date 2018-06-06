package org.ugguss.controllerimpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ugguss.generated.controller.LoginApi;
import org.ugguss.generated.model.LoginRequest;
import org.ugguss.generated.model.UserProfile;
import org.ugguss.model.User;
import org.ugguss.service.IUserService;
import org.ugguss.util.constants.RestEndpointConstants;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T20:43:54.638-04:00")

@RestController
public class LoginApiController implements LoginApi {

    @Autowired
    private IUserService userService;

    @Override
    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.LOGIN,
            produces = { "application/json" },
            method = RequestMethod.POST)
    public ResponseEntity<UserProfile> login(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LoginRequest loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());

        UserProfile userProfile = new UserProfile();
        userProfile.firstName(user.getUsername());

        return new ResponseEntity<UserProfile>(userProfile ,HttpStatus.OK);
    }
}
