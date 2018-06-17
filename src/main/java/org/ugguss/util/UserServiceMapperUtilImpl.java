package org.ugguss.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import org.ugguss.generated.model.AppUser;
import org.ugguss.model.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-16T21:09:33-0500",
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
                user.setDob( new SimpleDateFormat().parse( appUser.getDateOfBirth() ) );
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
            appUser.setDateOfBirth( new SimpleDateFormat().format( user.getDob() ) );
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
}
