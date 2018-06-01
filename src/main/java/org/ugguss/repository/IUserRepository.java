package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.User;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {
}
