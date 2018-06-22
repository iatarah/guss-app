package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;
import org.ugguss.model.GussMember;
import org.ugguss.model.GussMemberContribution;
import org.ugguss.repository.IGussMemberContributionRepository;
import org.ugguss.service.IGussMemberContributionService;
import org.ugguss.service.IGussMemberService;
import org.ugguss.util.ContributionServiceMapperUtil;
import org.ugguss.util.constants.AppConstants;

@Service("GussMemberContributionServiceImpl")
@Transactional
//@Qualifier(value = "GussMemberContributionServiceImpl")
public class GussMemberContributionServiceImpl implements IGussMemberContributionService{
	@Autowired
	private IGussMemberService iGussMemberService;
	@Autowired
	private ContributionServiceMapperUtil contributionServiceMapperUtil;
	@Autowired
	private IGussMemberContributionRepository  iGussMemberContributionRepository;
	
	@Override
	public ContributionResponse createContribution(ContributionRequest contributionRequest) {
		
		ContributionResponse response = new ContributionResponse();
		response.setBaseResponse(new BaseResponse());
		
		if(contributionRequest == null
				|| contributionRequest.getContribution() == null) {
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		GussMember gussMember = iGussMemberService.getGussMemberByMemberId(
				contributionRequest.getContribution().getMemberId());
		GussMemberContribution dbContribution = contributionServiceMapperUtil
				.contributionDTOtoDbContribution(contributionRequest.getContribution());
		dbContribution.setGussMember(gussMember);
		GussMemberContribution savedContribution = iGussMemberContributionRepository.save(dbContribution);
		response.setContribution(
					contributionServiceMapperUtil.dbContributionToDTOcontribution(savedContribution));
		response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return response;
			 
	}

}
