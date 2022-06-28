package com.fms.springEx1.Security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Rrole saveRole(Rrole role) {
		return roleRepository.save(role);
	}

	@Override
	public List<Rrole> ReadAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Rrole getRoleByRoleName(String roleName) {
		return roleRepository.findByRole(roleName);
	}

}
