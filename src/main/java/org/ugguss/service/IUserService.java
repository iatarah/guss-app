package org.ugguss.service;

import org.ugguss.generated.model.AppUser;
import org.ugguss.model.User;

public interface IUserService {
    User registerUser(AppUser user);
    User getUserByUserId(String userId);
    User getUserByEmail(String emailId);
}
