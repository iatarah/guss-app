package org.ugguss.service.serviceImpl.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.Member;
import org.ugguss.generated.model.UserRegistrationRequest;
import org.ugguss.generated.model.UserRegistrationResponse;
import org.ugguss.model.GussMember;
import org.ugguss.model.MembershipCategory;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.repository.IGussMemberRepository;
import org.ugguss.repository.IUserRepository;
import org.ugguss.service.IMembershipCategoryService;
import org.ugguss.service.IRoleService;
import org.ugguss.util.RegistrationUtil;
import org.ugguss.util.UserServiceMapperUtil;
import org.ugguss.util.constants.AppConstants;

import java.util.Collection;

@Component
@Qualifier(value="MemberUserServiceImplProvider")
public class MemberUserServiceImplProvider extends UserServiceImplProvider{
	@Autowired
	private IUserRepository iUserRepository;
	@Autowired
	private UserServiceMapperUtil userServiceMapperUtil;
	@Autowired
	private IRoleService iRoleService;
	@Autowired
	private IMembershipCategoryService iMembershipCategoryService;
	@Autowired
	private IGussMemberRepository iGussMemberRepository;
	
	@Override
	public UserRegistrationResponse registerUser(UserRegistrationRequest userRegistrationRequest) {
		
		UserRegistrationResponse response = new UserRegistrationResponse();
		response.setBaseResponse(new BaseResponse());
		
		if(userRegistrationRequest == null
				|| userRegistrationRequest.getAppUser() == null
				|| userRegistrationRequest.getMember() == null) {
			// TODO : log
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		AppUser appUser = userRegistrationRequest.getAppUser();
		User user = userServiceMapperUtil.appUserToDbUser(appUser);
		Role role = iRoleService.getRoleByRoleName(AppConstants.MEMBER);	
		
		if(user == null || role == null) {
			// TODO : log
			response.getBaseResponse().setReturnCode(AppConstants.ERROR_CODE);
			return response;
		}
		
		RegistrationUtil.populateUserExtraAttributes(userRegistrationRequest, role, user);
		
		try {
			User savedUser =  iUserRepository.save(user);
			// TODO: if user is saved successfully, add member object to member table
			GussMember gussMember = userServiceMapperUtil.dtoMemberTodbGussMember(userRegistrationRequest.getMember());
			MembershipCategory membershipCategory = iMembershipCategoryService.getCategoryByCategoryName(
					(userRegistrationRequest.getMember().getMembershipCategory() != null) ?
							userRegistrationRequest.getMember().getMembershipCategory().toString() : null);
			gussMember.setMembershipCategory(membershipCategory);
			gussMember.setUser(savedUser);
			
			GussMember savedGussMember = iGussMemberRepository.save(gussMember);
			Member dtoMember = userServiceMapperUtil.gussMemberTodtoMember(savedGussMember);
			AppUser dtoUser = userServiceMapperUtil.dbUserToAppUser(savedUser);
			
			response.setAppUser(dtoUser);
			response.getBaseResponse().setReturnCode(AppConstants.SUCCESS_CODE);
			//response.set
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
		return null;
	}

}
