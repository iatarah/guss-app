package org.ugguss.service.serviceImpl.provider;

import org.ugguss.model.User;
import org.ugguss.service.IUserService;

public abstract class UserServiceImplProvider implements IUserService{
	
	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		return new User();
	}

	@Override
	public User getUserByEmail(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
