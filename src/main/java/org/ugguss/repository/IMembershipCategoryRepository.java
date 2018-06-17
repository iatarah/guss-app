package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ugguss.model.MembershipCategory;

public interface IMembershipCategoryRepository extends JpaRepository<MembershipCategory, Integer> {
	@Query("FROM MembershipCategory c WHERE c.id = :id")
	MembershipCategory findCategoryByCategoryId(@Param("id") String categoryId);
	
	@Query("FROM MembershipCategory c WHERE c.categoryName = :categoryName")
	MembershipCategory findCategoryByCategoryName(@Param("categoryName") String categoryName);
}
