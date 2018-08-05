package org.ugguss.util;

import java.util.Date;

import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.util.constants.AppConstants;

public class RegistrationUtil {
	public static User populateUserExtraAttributes(UserRegistrationRequest request, Role role, User user) {
		user.setRole(role);
		user.setDateCreated(new Date());
		user.setStatus(AppConstants.ACTIVE_STATUS);
		return user;		
	}
}
