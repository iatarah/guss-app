package org.ugguss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ugguss.model.GussMemberContribution;

public interface IGussMemberContributionRepository extends JpaRepository<GussMemberContribution, Integer> {
	
	@Query("FROM GussMemberContribution c WHERE c.gussMember.memberSsn = :memberId")
	List<GussMemberContribution> findContributionByMemberId(@Param("memberId") String memberId);
}
