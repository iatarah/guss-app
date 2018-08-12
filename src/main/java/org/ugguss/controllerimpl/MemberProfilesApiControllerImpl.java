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
import org.ugguss.generated.controller.MemberProfilesApi;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.MemberProfileRequest;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.service.IUserService;
import org.ugguss.service.serviceImpl.provider.GussMemberServiceImplProvider;
import org.ugguss.util.constants.AppConstants;
import org.ugguss.util.constants.RestEndpointConstants;

import io.swagger.annotations.ApiParam;

@Controller
public class MemberProfilesApiControllerImpl implements MemberProfilesApi {
	private static final Logger LOG = LogManager.getLogger(MemberProfilesApiControllerImpl.class);
	@Autowired
	@Qualifier(value="userDetailsService")
    private IUserService iUserService;
	@Autowired
	private GussMemberServiceImplProvider gussMemberServiceImplProvider;
	
    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.GET_MEMBER_PROFILE_WITH_MEMBER_ID,
            produces = { "application/json" }, 
            method = RequestMethod.POST)
    public ResponseEntity<UserProfileResponse> retrieveMemberWithMemberId(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MemberProfileRequest memberProfileRequest) {
    	String memberId = (memberProfileRequest != null) ? memberProfileRequest.getMemberId() : null;
    	LOG.debug("Calling MemberProfilesApi with memberId: {}", memberId);
    	UserProfileResponse response;
		try {
			response = gussMemberServiceImplProvider.getUserByGussMemberId(memberId);
		} catch (Exception e) {
			LOG.error("error in retrieving member with memberId: {}", memberId, e.getStackTrace());
			response = new UserProfileResponse();
			response.baseResponse(new BaseResponse());
			response.getBaseResponse().returnCode(AppConstants.ERROR_CODE);
		}
        return new ResponseEntity<UserProfileResponse>(response, HttpStatus.OK);
    }
}
