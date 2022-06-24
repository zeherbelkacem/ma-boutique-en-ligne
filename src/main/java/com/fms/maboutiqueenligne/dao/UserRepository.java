package com.fms.maboutiqueenligne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.maboutiqueenligne.entities.User;

/**
 * User Repository
 * @author Delmerie JOHN ROSE
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
