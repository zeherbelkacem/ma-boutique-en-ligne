package com.fms.springEx1.Security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Rrole, Long>{

	public Rrole findByRole(String roleName);

}
