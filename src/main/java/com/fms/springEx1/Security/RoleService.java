package com.fms.springEx1.Security;

import java.util.List;

public interface RoleService {
	public Rrole saveRole(Rrole role);

	public List<Rrole>  ReadAllRoles();

	public Rrole getRoleByRoleName(String roleName);
}
