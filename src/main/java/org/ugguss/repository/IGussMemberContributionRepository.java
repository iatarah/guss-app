package org.ugguss.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ugguss.model.GussMemberContribution;

public interface IGussMemberContributionRepository extends JpaRepository<GussMemberContribution, Integer> {
	
	@Query("FROM GussMemberContribution c WHERE c.gussMember.memberSsn = :memberId")
	List<GussMemberContribution> findContributionByMemberId(@Param("memberId") String memberId);
	
	@Query("FROM GussMemberContribution c WHERE c.gussMember.memberSsn = :memberId AND (c.fiscalYear BETWEEN :startDate AND :endDate)")
	List<GussMemberContribution> findContributionByMemberIdAndDate(@Param("memberId") String memberId, 
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	
	@Query("FROM GussMemberContribution c WHERE c.paymentDate BETWEEN :startDate AND :endDate")
	List<GussMemberContribution> findContributionByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
