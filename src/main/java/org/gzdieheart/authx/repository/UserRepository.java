package org.gzdieheart.authx.repository;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import org.gzdieheart.authx.entities.User;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/11/29
 * JPA用户仓库接口
 */

//@Repository
//public interface UserRepository extends JpaRepository<User, Integer> {
public interface UserRepository {
    // Since email is unique, we'll find users by email
    Optional<User> findByEmail(String email);
}
