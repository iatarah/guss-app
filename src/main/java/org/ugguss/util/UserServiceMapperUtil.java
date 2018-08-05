package org.ugguss.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.Gender;
import org.ugguss.generated.model.GussMemberCategory;
import org.ugguss.generated.model.Member;
import org.ugguss.generated.model.UserRole;
import org.ugguss.model.GussMember;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.util.constants.AppConstants;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  UserServiceMapperUtil {
	
	@Mappings({
		@Mapping(target = "id", source = "userId"),
		@Mapping(target = "email", source = "email"),
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "middleName", source = "middleName"),
		@Mapping(target = "gender", source = "gender"),
		@Mapping(target = "dob", source = "dateOfBirth", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "status", source = "status"),
		//@Mapping(target = "dateCreated", source = ""),
		//@Mapping(target = "lastUpdated", source = ""),
	})
	User appUserToDbUser(AppUser appUser);
	
	
	@Mappings({
		@Mapping(target="userRole", source="role"),
		@Mapping(target = "userId", source = "id"),
		@Mapping(target = "email", source = "email"),
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "middleName", source = "middleName"),
		@Mapping(target = "gender", source = "gender"),
		@Mapping(target = "dateOfBirth", source = "dob", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "status", source = "status"),
		@Mapping(target = "dateCreated", source = "dateCreated", dateFormat = "dd-MM-yyyy HH:mm:ss"),
		@Mapping(target = "lastUpdatedDate", source = "lastUpdated", dateFormat = "dd-MM-yyyy HH:mm:ss")
	})
	AppUser dbUserToAppUser(User user);
	
	
	public default UserRole dbRoleToUserRole (Role role) {
		if(role == null || role.getRoleName() == null) {
			return null;
		}
		String roleName = null;
		switch (role.getRoleName()) {
		case AppConstants.ADMIN:
			roleName = "ADMIN";
			break;
		case AppConstants.MEMBER:
			roleName = "MEMBER";
			break;
		case AppConstants.STAFF:
			roleName = "STAFF";
			break;
		default:
			break;
		}
		UserRole userRole = UserRole.fromValue(roleName);
		return userRole;
	}
	
	public default Gender dbUserGenderToAppUserGender (String gender) {
		if(gender == null) {
			return null;
		}
		Gender appUserGender = Gender.fromValue(gender);
		return appUserGender;
	}
	
	@Mappings({
		@Mapping(target = "basicSalary", source = "currentSalary"),
		@Mapping(target = "address", source = "address"),
		@Mapping(target = "retirementDate", source = "maturityDate", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "joinDate", source = "policyStartDate", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "memberId", source = "memberSsn"),
		@Mapping(target = "membershipStatus", source = "membershipStatus")
	})
	Member gussMemberTodtoMember(GussMember gussMember) ;
	
	
	@Mappings({
		@Mapping(target = "policyStartDate", source = "joinDate", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "maturityDate", source = "retirementDate", dateFormat = "dd-MM-yyyy"),
		@Mapping(target = "address", source = "address"),
		@Mapping(target = "memberSsn", source = "memberId"),
		@Mapping(target = "currentSalary", source = "basicSalary"),
	})
	GussMember dtoMemberTodbGussMember(Member member) ;
	
	default GussMemberCategory map(org.ugguss.model.MembershipCategory value) {
		
		if(value == null) {
			return null;
		}
		GussMemberCategory gussMemberCategory = GussMemberCategory.fromValue(value.getCategoryName());
		return gussMemberCategory;
		
	}
	
/*	
	public default String appUserGenderTodbUserGender (Gender gender) {
		if(gender == null) {
			return null;
		}
		return gender.toString();
	}*/
}
