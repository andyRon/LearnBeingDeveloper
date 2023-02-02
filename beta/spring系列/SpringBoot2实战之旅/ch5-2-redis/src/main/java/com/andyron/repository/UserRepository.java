package com.andyron.repository;

import com.andyron.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andy Ron
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
