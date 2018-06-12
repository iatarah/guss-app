package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.ugguss.model.Role;
import org.ugguss.repository.IRoleRepository;
import org.ugguss.service.IRoleService;

public class RoleServiceImplProvider implements IRoleService{
    @Autowired
    private IRoleRepository iRoleRepository;

	@Override
	public Role getRoleByRoleId(String roleId) {
		return iRoleRepository.findRoleByRoleId(roleId);
	}

	@Override
	public Role getRoleByRoleName(String roleName) {
		return iRoleRepository.findRoleByRoleName(roleName);
	}

}
