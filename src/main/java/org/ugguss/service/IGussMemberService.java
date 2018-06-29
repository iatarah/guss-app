package org.ugguss.service;

import org.ugguss.model.GussMember;

public interface IGussMemberService {
	GussMember getGussMemberByMemberId(String memberId);
	GussMember getGussMemberByUserId(int userId);
}
