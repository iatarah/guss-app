package org.ugguss.controllerimpl;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.ugguss.generated.controller.MemberContributionApi;
import org.ugguss.generated.model.ContributionHistoryResponse;
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
	method = RequestMethod.PUT)
    public  ResponseEntity<ContributionResponse> createContribution(@ApiParam(value = "" ,required=true )  @Valid @RequestBody ContributionRequest contributionRequest) {
		ContributionResponse response = iGussMemberContributionService.createContribution(contributionRequest);
        return new ResponseEntity<ContributionResponse>(response, HttpStatus.OK);
    }

	
	@Override
    @RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.MEMBER_CONTRIBUTION,
    produces = { "application/json" }, 
    method = RequestMethod.GET)
    public ResponseEntity<ContributionHistoryResponse> getContribution(@ApiParam(value = "",required=true ) @PathVariable("memberId") String memberId,@ApiParam(value = "") @RequestParam(value = "startDate", required = false) String startDate,@ApiParam(value = "") @RequestParam(value = "endDate", required = false) String endDate) {
		ContributionHistoryResponse response = iGussMemberContributionService.getContribution(memberId, startDate, endDate);
        return new ResponseEntity<ContributionHistoryResponse>(response, HttpStatus.OK);
	}
}
