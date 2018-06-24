package org.ugguss.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.generated.model.GussMemberCategory;
import org.ugguss.generated.model.Member;
import org.ugguss.generated.model.Member.MembershipStatusEnum;
import org.ugguss.model.GussMember;
import org.ugguss.model.MembershipCategory;
import org.ugguss.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-24T09:36:24-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class UserServiceMapperUtilImpl implements UserServiceMapperUtil {

    @Override
    public User appUserToDbUser(AppUser appUser) {
        if ( appUser == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( appUser.getFirstName() );
        user.setLastName( appUser.getLastName() );
        if ( appUser.getGender() != null ) {
            user.setGender( appUser.getGender().name() );
        }
        try {
            if ( appUser.getDateOfBirth() != null ) {
                user.setDob( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( appUser.getDateOfBirth() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        user.setMiddleName( appUser.getMiddleName() );
        if ( appUser.getUserId() != null ) {
            user.setId( appUser.getUserId().intValue() );
        }
        user.setEmail( appUser.getEmail() );
        if ( appUser.getStatus() != null ) {
            user.setStatus( appUser.getStatus().intValue() );
        }
        user.setPassword( appUser.getPassword() );
        try {
            if ( appUser.getDateCreated() != null ) {
                user.setDateCreated( new SimpleDateFormat().parse( appUser.getDateCreated() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }

        return user;
    }

    @Override
    public AppUser dbUserToAppUser(User user) {
        if ( user == null ) {
            return null;
        }

        AppUser appUser = new AppUser();

        appUser.setFirstName( user.getFirstName() );
        appUser.setLastName( user.getLastName() );
        if ( user.getLastUpdated() != null ) {
            appUser.setLastUpdatedDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( user.getLastUpdated() ) );
        }
        if ( user.getDateCreated() != null ) {
            appUser.setDateCreated( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( user.getDateCreated() ) );
        }
        appUser.setGender( dbUserGenderToAppUserGender( user.getGender() ) );
        appUser.setMiddleName( user.getMiddleName() );
        if ( user.getDob() != null ) {
            appUser.setDateOfBirth( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( user.getDob() ) );
        }
        appUser.setUserRole( dbRoleToUserRole( user.getRole() ) );
        appUser.setUserId( BigDecimal.valueOf( user.getId() ) );
        appUser.setEmail( user.getEmail() );
        if ( user.getStatus() != null ) {
            appUser.setStatus( BigDecimal.valueOf( user.getStatus() ) );
        }
        appUser.setPassword( user.getPassword() );

        return appUser;
    }

    @Override
    public Member gussMemberTodtoMember(GussMember gussMember) {
        if ( gussMember == null ) {
            return null;
        }

        Member member = new Member();

        member.setAddress( gussMember.getAddress() );
        if ( gussMember.getPolicyStartDate() != null ) {
            member.setJoinDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( gussMember.getPolicyStartDate() ) );
        }
        if ( gussMember.getMaturityDate() != null ) {
            member.setRetirementDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).format( gussMember.getMaturityDate() ) );
        }
        if ( gussMember.getCurrentSalary() != null ) {
            member.setBasicSalary( BigDecimal.valueOf( gussMember.getCurrentSalary() ) );
        }
        if ( gussMember.getMembershipStatus() != null ) {
            member.setMembershipStatus( Enum.valueOf( MembershipStatusEnum.class, gussMember.getMembershipStatus() ) );
        }
        member.setMemberId( gussMember.getMemberSsn() );
        member.setMembershipCategory( map( gussMember.getMembershipCategory() ) );

        return member;
    }

    @Override
    public GussMember dtoMemberTodbGussMember(Member member) {
        if ( member == null ) {
            return null;
        }

        GussMember gussMember = new GussMember();

        try {
            if ( member.getJoinDate() != null ) {
                gussMember.setPolicyStartDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( member.getJoinDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        gussMember.setAddress( member.getAddress() );
        gussMember.setMemberSsn( member.getMemberId() );
        try {
            if ( member.getRetirementDate() != null ) {
                gussMember.setMaturityDate( new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" ).parse( member.getRetirementDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        gussMember.setMembershipCategory( gussMemberCategoryToMembershipCategory( member.getMembershipCategory() ) );
        if ( member.getMembershipStatus() != null ) {
            gussMember.setMembershipStatus( member.getMembershipStatus().name() );
        }

        return gussMember;
    }

    protected MembershipCategory gussMemberCategoryToMembershipCategory(GussMemberCategory gussMemberCategory) {
        if ( gussMemberCategory == null ) {
            return null;
        }

        MembershipCategory membershipCategory = new MembershipCategory();

        return membershipCategory;
    }
}
