/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.ugguss.generated.controller;

import org.ugguss.generated.model.UserProfile;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T14:37:17.942-05:00")

@Api(value = "profiles", description = "the profiles API")
public interface ProfilesApi {

    @ApiOperation(value = "Returns response object for basic member profile info", notes = "", response = UserProfile.class, tags={ "/accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserProfile.class) })
    
    @RequestMapping(value = "/profiles/{memberId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<UserProfile> getMember(@ApiParam(value = "",required=true ) @PathVariable("memberId") String memberId) {
        // do some magic!
        return new ResponseEntity<UserProfile>(HttpStatus.OK);
    }


    @ApiOperation(value = "Update User Profile Info", notes = "", response = Object.class, tags={ "/accounts", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Object.class) })
    
    @RequestMapping(value = "/profiles/{memberId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Object> updateMember(@ApiParam(value = ""  )  @Valid @RequestBody Object body) {
        // do some magic!
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
