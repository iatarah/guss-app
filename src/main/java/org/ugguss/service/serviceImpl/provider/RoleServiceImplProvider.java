package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.ugguss.repository.IRoleRepository;
import org.ugguss.model.Role;
import org.ugguss.service.IRoleService;

@Component
@Qualifier(value="RoleServiceImplProvider")
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
