package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.Role;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role, Integer> {
	
	@Query("FROM Role r WHERE r.roleId = :roleId")
	Role findRoleByRoleId(@Param("roleId") String roleId);
	
	@Query("FROM Role r WHERE r.roleId = :roleName")
	Role findRoleByRoleName(@Param("roleName") String roleName);
}
