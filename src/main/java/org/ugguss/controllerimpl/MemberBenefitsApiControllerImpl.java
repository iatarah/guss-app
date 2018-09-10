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
import org.ugguss.generated.controller.MemberBenefitsApi;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.BenefitsRequest;
import org.ugguss.generated.model.BenefitsResponse;
import org.ugguss.service.IGussMemberContributionService;
import org.ugguss.util.constants.AppConstants;
import org.ugguss.util.constants.RestEndpointConstants;
import io.swagger.annotations.ApiParam;

@Controller
public class MemberBenefitsApiControllerImpl implements MemberBenefitsApi{
	private static final Logger LOG = LogManager.getLogger(MemberBenefitsApiControllerImpl.class);
	
	@Autowired
	@Qualifier(value="GussMemberContributionServiceImpl")
	private IGussMemberContributionService iGussMemberContributionService;
	
	@Override
	@RequestMapping(value = RestEndpointConstants.Constants.BASE_API +"/" + RestEndpointConstants.Constants.MEMBER_BENFITS,
	produces = { "application/json" }, 
	method = RequestMethod.POST)
	public ResponseEntity<BenefitsResponse> retrieveBenefits(@ApiParam(value = "" ,required=true )  @Valid @RequestBody BenefitsRequest benefitsRequest) {
		BenefitsResponse response = null;
		try {
			response = iGussMemberContributionService.retrieveBenefits(benefitsRequest);
		} catch (Exception e) {
			LOG.error("Exception in retrieving benefits", e.getCause());
			response = new BenefitsResponse();
			response.setBaseResponse(new BaseResponse());
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
		}
		return new ResponseEntity<BenefitsResponse>(response, HttpStatus.OK);
	}
}
