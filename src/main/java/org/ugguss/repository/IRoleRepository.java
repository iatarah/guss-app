package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ugguss.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
