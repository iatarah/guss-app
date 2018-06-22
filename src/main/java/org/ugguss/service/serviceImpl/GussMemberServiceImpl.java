package org.ugguss.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.GussMember;
import org.ugguss.repository.IGussMemberRepository;
import org.ugguss.service.IGussMemberService;

@Service("GussMemberServiceImpl")
@Transactional
public class GussMemberServiceImpl implements IGussMemberService {
	
	@Autowired
	private IGussMemberRepository iGussMemberRepository;
	
	@Override
	public GussMember getGussMemberByMemberId(String memberId) {
		return iGussMemberRepository.findGussMemberByMemberId(memberId);
	}

}
