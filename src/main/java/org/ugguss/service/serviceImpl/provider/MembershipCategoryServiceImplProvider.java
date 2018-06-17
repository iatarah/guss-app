package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.ugguss.model.MembershipCategory;
import org.ugguss.repository.IMembershipCategoryRepository;
import org.ugguss.service.IMembershipCategoryService;

@Component
@Qualifier(value="MembershipCategoryServiceImplProvider")
public class MembershipCategoryServiceImplProvider implements IMembershipCategoryService {
    @Autowired
    private IMembershipCategoryRepository iMembershipCategoryRepository;

	@Override
	public MembershipCategory getCategoryByCategoryId(String categoryId) {
		return iMembershipCategoryRepository.findCategoryByCategoryId(categoryId);
	}

	@Override
	public MembershipCategory getCategoryByCategoryName(String categoryName) {
		return iMembershipCategoryRepository.findCategoryByCategoryName(categoryName);
	}

}
