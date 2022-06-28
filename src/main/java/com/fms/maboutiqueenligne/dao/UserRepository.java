package com.fms.maboutiqueenligne.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.User;

/**
 * User Repository
 * @author Delmerie JOHN ROSE
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	Page<User> findByEmailContains(String email, Pageable pageable);
	
}
