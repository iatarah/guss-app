package org.ugguss.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.UserRole;
import org.ugguss.model.Role;
import org.ugguss.model.User;
import org.ugguss.service.serviceImpl.provider.RoleServiceImplProvider;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  UserServiceMapperUtil {
	
	//UserServiceMapperUtil INSTANCE = Mappers.getMapper(UserServiceMapperUtil.class);
	
	@Mappings({
		//@Mapping(target = "Role", source = ""), // we probably need to replace this with roleId
		@Mapping(target = "id", source = "userId"),
		@Mapping(target = "email", source = "email"),
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "middleName", source = "middleName"),
		//@Mapping(target = "gender", source = ""),
		@Mapping(target = "dob", source = "dateOfBirth"),
		@Mapping(target = "status", source = "status"),
		//@Mapping(target = "dateCreated", source = ""),
		//@Mapping(target = "lastUpdated", source = ""),
	})
	User appUserToDbUser(AppUser appUser);
	
	
	@Mappings({
		//@Mapping(target = "", source = "Role"), // we probably need to replace this with roleId
		@Mapping(target = "userId", source = "id"),
		@Mapping(target = "email", source = "email"),
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "middleName", source = "middleName"),
		//@Mapping(target = "", source = "gender"),
		@Mapping(target = "dateOfBirth", source = "dob"),
		@Mapping(target = "status", source = "status"),
		@Mapping(target = "dateCreated", source = "dateCreated"),
		@Mapping(target = "lastUpdatedDate", source = "lastUpdated"),
	})
	AppUser dbUserToAppUser(User user);
	
	public default Role userRoleToDbRole(UserRole userRole) {
		RoleServiceImplProvider provider = new RoleServiceImplProvider();
		return provider.getRoleByRoleName(userRole.name());
	}
	
	public default UserRole dbRoleToUserRole (Role role) {
		return UserRole.fromValue(role.getRoleName());
	}
}
