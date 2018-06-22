package org.ugguss.controllerimpl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ugguss.generated.controller.MemberContributionApi;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;
import org.ugguss.service.IGussMemberContributionService;
import org.ugguss.util.constants.RestEndpointConstants;

import io.swagger.annotations.ApiParam;

@Controller
public class MemberContributionApiControllerImpl implements MemberContributionApi {
	@Autowired
	@Qualifier(value="GussMemberContributionServiceImpl")
	private IGussMemberContributionService iGussMemberContributionService;
	
	@Override
	@RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.MEMBER_CONTRIBUTION,
	produces = { "application/json" }, 
	method = RequestMethod.POST)
    public  ResponseEntity<ContributionResponse> createContribution(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ContributionRequest contributionRequest) {
        // do some magic!
        return new ResponseEntity<ContributionResponse>(HttpStatus.OK);
    }

}
