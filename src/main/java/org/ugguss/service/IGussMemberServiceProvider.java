package org.ugguss.service;

import org.ugguss.generated.model.BenefitsRequest;
import org.ugguss.generated.model.BenefitsResponse;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.model.GussMember;

public interface IGussMemberServiceProvider  extends IGussMemberContributionService  {
	GussMember getGussMemberByMemberId(String memberId);
	GussMember getGussMemberByUserId(int userId);
	UserProfileResponse getUserByGussMemberId(String memberId) throws Exception;
	BenefitsResponse retrieveBenefits(BenefitsRequest benefitsRequest) throws Exception;
}
