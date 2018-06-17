package org.ugguss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.ugguss.model.User;

import java.util.List;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("FROM User u JOIN FETCH u.role r  WHERE u.email = :email")
    User findUserByEmail(@Param("email") String email);

    @Query("FROM User u JOIN FETCH u.role r  WHERE u.id = :id")
    User findUserByUserId(@Param("id") String id);

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    List<User> findAllUser();

}
