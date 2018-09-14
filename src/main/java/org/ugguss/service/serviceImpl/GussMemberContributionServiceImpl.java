package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.BenefitsRequest;
import org.ugguss.generated.model.BenefitsResponse;
import org.ugguss.generated.model.ContributionHistoryResponse;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;
import org.ugguss.service.IGussMemberContributionService;
import org.ugguss.service.IGussMemberServiceProvider;

@Service("GussMemberContributionServiceImpl")
@Transactional
//@Qualifier(value = "GussMemberContributionServiceImpl")
public class GussMemberContributionServiceImpl implements IGussMemberContributionService{

	@Autowired
	private IGussMemberServiceProvider iGussMemberServiceProvider;
	
	@Override
	public ContributionResponse createContribution(ContributionRequest contributionRequest) {
		return iGussMemberServiceProvider.createContribution(contributionRequest);			 
	}

	@Override
	public ContributionHistoryResponse getContribution(String memberId, String startDate, String endDate) {
		return iGussMemberServiceProvider.getContribution(memberId, startDate, endDate);
	}

	@Override
	public BenefitsResponse retrieveBenefits(BenefitsRequest benefitsRequest) throws Exception{
		return iGussMemberServiceProvider.retrieveBenefits(benefitsRequest);
	}

}
