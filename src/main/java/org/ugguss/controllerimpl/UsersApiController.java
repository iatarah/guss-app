package org.ugguss.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.ugguss.generated.controller.UsersApi;
import org.ugguss.generated.model.Person;
import org.ugguss.model.User;
import org.ugguss.service.IUserService;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-31T21:30:34.195-04:00")

@RestController
public class UsersApiController implements UsersApi {
    @Autowired
    private IUserService userService;

    @Override
    public ResponseEntity<Person> getCurrentUser() {
        User user =  userService.getCurrentUser(001);
        // do some magic!
        return new ResponseEntity<Person>(new Person(),HttpStatus.OK);
    }
}
