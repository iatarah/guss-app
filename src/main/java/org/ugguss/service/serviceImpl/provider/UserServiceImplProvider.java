package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.Member;
import org.ugguss.generated.model.UserProfileResponse;
import org.ugguss.model.GussMember;
import org.ugguss.model.User;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IUserService;
import org.ugguss.util.UserServiceMapperUtil;
import org.ugguss.util.constants.AppConstants;

public abstract class UserServiceImplProvider implements IUserService{
	@Autowired
	private GussMemberServiceImplProvider gussMemberServiceImplProvider;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserServiceMapperUtil userServiceMapperUtil;
    
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
	
	@Override
	public UserProfileResponse getUserByUserName(String userName) {
		UserProfileResponse userProfileResponse = new UserProfileResponse();
		userProfileResponse.baseResponse(new BaseResponse());
		
		User user = iUserRepository.findUserByEmail(userName);
		if(user==null) {
			//TODO: log msg here to indicate user is null
			userProfileResponse.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return userProfileResponse;
		}
		userProfileResponse.setAppUser(userServiceMapperUtil.dbUserToAppUser(user));
		
		if(AppConstants.MEMBER.equalsIgnoreCase(user.getRole().getRoleName())) {
			GussMember gussMember = gussMemberServiceImplProvider.getGussMemberByUserId(user.getId());
			Member member = userServiceMapperUtil.gussMemberTodtoMember(gussMember);
			member.setContributionHistory(
					gussMemberServiceImplProvider.getContribution(member.getMemberId(), null, null).getContributionHistory());
			userProfileResponse.setGussMember(member);
			
		}
		userProfileResponse.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
		return userProfileResponse;
	}
}
