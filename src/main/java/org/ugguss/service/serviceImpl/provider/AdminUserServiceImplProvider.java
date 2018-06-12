package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.ugguss.generated.model.AppUser;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.util.UserServiceMapperUtil;

public class AdminUserServiceImplProvider extends UserServiceImplProvider{
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;

	@Override
	public User registerUser(AppUser appUser) {
		User user = userServiceMapperUtil.appUserToDbUser(appUser);
		return iUserRepository.save(user);
	}
}
