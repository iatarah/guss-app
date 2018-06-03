package org.ugguss.controllerimpl;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ugguss.generated.controller.ProfilesApi;
import org.ugguss.generated.model.LiferayUser;
import org.ugguss.generated.model.UserProfile;
import org.ugguss.model.User;
import org.ugguss.service.IUserService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-31T21:30:34.195-04:00")

@Controller
public class ProfilesApiController implements ProfilesApi {

    @Autowired
    private IUserService userService;

    @Override
    @RequestMapping(value = "/o/rest/accounts/api/v1/profiles/{memberId}",
    produces = { "application/json" }, 
    method = RequestMethod.GET)
    public ResponseEntity<UserProfile> getMember(@ApiParam(value = "",required=true ) @PathVariable("memberId") String memberId) {
        userService.getUserByEmail(memberId);
        return new ResponseEntity<UserProfile>(new UserProfile(), HttpStatus.OK);
    }


}
