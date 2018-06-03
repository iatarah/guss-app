/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.ugguss.generated.controller;

import org.ugguss.generated.model.Person;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:45:47.270-05:00")

@Api(value = "people", description = "the people API")
public interface PeopleApi {

    @ApiOperation(value = "Creates a new Person object based on suppplied JSON and returns the created object including ID", notes = "", response = Person.class, tags={ "/samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    
    @RequestMapping(value = "/people",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Person> addPerson(@ApiParam(value = ""  )  @Valid @RequestBody Person body) {
        // do some magic!
        return new ResponseEntity<Person>(HttpStatus.OK);
    }


    @ApiOperation(value = "Removes a single Person object based on suppplied ID", notes = "", response = Person.class, tags={ "/samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    
    @RequestMapping(value = "/people/{id}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Person> deletePerson(@ApiParam(value = "",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Person>(HttpStatus.OK);
    }


    @ApiOperation(value = "Returns the entire collection of in-memory Person objects", notes = "", response = Person.class, responseContainer = "List", tags={ "/samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class, responseContainer = "List") })
    
    @RequestMapping(value = "/people",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Person>> getAllPeople() {
        // do some magic!
        return new ResponseEntity<List<Person>>(HttpStatus.OK);
    }


    @ApiOperation(value = "Returns a single Person object based on suppplied ID", notes = "", response = Person.class, tags={ "/samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    
    @RequestMapping(value = "/people/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Person> getPerson(@ApiParam(value = "",required=true ) @PathVariable("id") String id) {
        // do some magic!
        return new ResponseEntity<Person>(HttpStatus.OK);
    }


    @ApiOperation(value = "Modifies an existing Person object based on suppplied JSON and uses the ID parameter to identify the target person", notes = "", response = Person.class, tags={ "/samples", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Person.class) })
    
    @RequestMapping(value = "/people/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    default ResponseEntity<Person> updatePerson(@ApiParam(value = "",required=true ) @PathVariable("id") String id,@ApiParam(value = ""  )  @Valid @RequestBody Person body) {
        // do some magic!
        return new ResponseEntity<Person>(HttpStatus.OK);
    }

}
