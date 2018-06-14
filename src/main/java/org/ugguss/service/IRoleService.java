package org.ugguss.service;

import org.ugguss.model.Role;

public interface IRoleService {
	Role getRoleByRoleId(String roleId);
	Role getRoleByRoleName(String roleName);
}
