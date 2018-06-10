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
import org.springframework.web.bind.annotation.*;
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
        System.out.println("Hello Am here");
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());

        UserProfile userProfile = new UserProfile();
        userProfile.firstName(user.getUsername());

        return new ResponseEntity<UserProfile>(userProfile ,HttpStatus.OK);
    }

    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.ADMIN_ONLY,
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<String> testAdminEndpoint() {
        System.out.println("Hello Am here on Admin");
//        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
//
//        UserProfile userProfile = new UserProfile();
//        userProfile.firstName(user.getUsername());
        String x = "Hello Admin";
        return new ResponseEntity<String>(x ,HttpStatus.OK);
    }

    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API + "/" + RestEndpointConstants.Constants.STAFF_ONLY,
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<String> testStaffEndpoint() {
        String x = "Hello Staff";
        return new ResponseEntity<String>(x, HttpStatus.OK);
    }


}
