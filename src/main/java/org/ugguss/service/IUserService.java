package org.ugguss.service;

import org.ugguss.model.User;

public interface IUserService {
    User registerUser(User user);
    User getUserByUserId(String userId);
    User getUserByEmail(String emailId);
}
