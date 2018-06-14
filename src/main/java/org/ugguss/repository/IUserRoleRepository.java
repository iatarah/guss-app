package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.Role;

@Repository
@Transactional
public interface IUserRoleRepository extends JpaRepository<Role, Integer> {

}
