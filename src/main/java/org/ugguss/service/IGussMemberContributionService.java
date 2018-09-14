package org.ugguss.service;

import org.ugguss.generated.model.BenefitsRequest;
import org.ugguss.generated.model.BenefitsResponse;
import org.ugguss.generated.model.ContributionHistoryResponse;
import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;


public interface IGussMemberContributionService {
	ContributionResponse createContribution (ContributionRequest contributionRequest);
	ContributionHistoryResponse getContribution(String memberId, String startDate, String endDate);
	BenefitsResponse retrieveBenefits(BenefitsRequest benefitsRequest) throws Exception;
}
