package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.model.GussMember;
import org.ugguss.repository.IGussMemberRepository;
import org.ugguss.service.IGussMemberService;
import org.ugguss.service.serviceImpl.provider.GussMemberServiceImplProvider;

@Service("GussMemberServiceImpl")
@Transactional
public class GussMemberServiceImpl implements IGussMemberService {
	
	@Autowired
	private IGussMemberRepository iGussMemberRepository;
	@Autowired
	private GussMemberServiceImplProvider gussMemberServiceImplProvider;
	
	@Override
	public GussMember getGussMemberByMemberId(String memberId) {
		return iGussMemberRepository.findGussMemberByMemberId(memberId);
	}

	@Override
	public GussMember getGussMemberByUserId(int userId) {
		return iGussMemberRepository.findGussMemberByUserId(userId);
	}

	@Override
	public UserProfileResponse getUserByGussMemberId(String memberId) throws Exception {
		return gussMemberServiceImplProvider.getUserByGussMemberId(memberId);
	}

}
