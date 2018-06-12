package org.ugguss.service;

import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.User;

public interface IUserService {
	UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest);
    User getUserByUserId(String userId);
    User getUserByEmail(String emailId);
}
