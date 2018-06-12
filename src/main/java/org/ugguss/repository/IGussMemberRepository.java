package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.GussMember;

@Repository
@Transactional
public interface IGussMemberRepository extends JpaRepository<GussMember, Integer> {
	
	@Query("FROM GussMember m WHERE m.memberId = :memberId")
	GussMember findGussMemberByMemberId(@Param("memberId") String memberId);
	
	@Query("FROM GussMember m WHERE m.user.id = :userId")
	GussMember findGussMemberByUserId(@Param("userId") String userId);
	
	@Query("FROM GussMember m WHERE m.user.id = :userId AND m.memberId = :memberId")
	GussMember findGussMemberByUserIdAndMemberId(@Param("userId") String userId, @Param("memberId") String memberId);
}
