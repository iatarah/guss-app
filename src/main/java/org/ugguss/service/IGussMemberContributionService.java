package org.ugguss.service;

import org.ugguss.generated.model.ContributionRequest;
import org.ugguss.generated.model.ContributionResponse;


public interface IGussMemberContributionService {
	ContributionResponse createContribution (ContributionRequest contributionRequest);
}
