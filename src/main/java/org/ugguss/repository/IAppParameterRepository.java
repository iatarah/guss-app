package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.AppParameter;

@Repository
@Transactional
public interface IAppParameterRepository extends JpaRepository<AppParameter, Integer>{
	@Query("FROM AppParameter param WHERE param.paramName = :paramName")
	AppParameter findParamByName(@Param("paramName") String paramName);

}
