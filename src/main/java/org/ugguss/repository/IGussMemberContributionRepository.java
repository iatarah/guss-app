package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugguss.model.GussMemberContribution;

public interface IGussMemberContributionRepository extends JpaRepository<GussMemberContribution, Integer> {

}
