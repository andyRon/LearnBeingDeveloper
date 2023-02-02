package com.andyron.repository;

import com.andyron.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andy Ron
 */
public interface UserRepository extends JpaRepository<User,Long> {


}
