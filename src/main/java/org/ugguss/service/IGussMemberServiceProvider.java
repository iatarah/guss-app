package org.ugguss.service;

import org.ugguss.model.GussMember;

public interface IGussMemberServiceProvider  extends IGussMemberContributionService  {
	GussMember getGussMemberByMemberId(String memberId);
	GussMember getGussMemberByUserId(int userId);
}
