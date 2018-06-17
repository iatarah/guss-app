package org.ugguss.service;

import org.ugguss.model.MembershipCategory;

public interface IMembershipCategoryService {
	MembershipCategory getCategoryByCategoryId(String categoryId);
	MembershipCategory getCategoryByCategoryName(String categoryName);
}
