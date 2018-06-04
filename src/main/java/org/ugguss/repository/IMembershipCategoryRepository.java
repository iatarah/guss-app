package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugguss.model.MembershipCategory;

public interface IMembershipCategoryRepository extends JpaRepository<MembershipCategory, Integer> {

}
