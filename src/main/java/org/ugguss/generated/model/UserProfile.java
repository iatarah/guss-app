package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserProfile
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T20:33:45.267-04:00")

public class UserProfile   {
  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("dob")
  private LocalDate dob = null;

  @JsonProperty("policyNumber")
  private Integer policyNumber = null;

  public UserProfile emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

   /**
   * Get emailAddress
   * @return emailAddress
  **/
  @ApiModelProperty(value = "")


  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public UserProfile firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public UserProfile lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public UserProfile middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

   /**
   * Get middleName
   * @return middleName
  **/
  @ApiModelProperty(value = "")


  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public UserProfile dob(LocalDate dob) {
    this.dob = dob;
    return this;
  }

   /**
   * Get dob
   * @return dob
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public UserProfile policyNumber(Integer policyNumber) {
    this.policyNumber = policyNumber;
    return this;
  }

   /**
   * Get policyNumber
   * @return policyNumber
  **/
  @ApiModelProperty(value = "")


  public Integer getPolicyNumber() {
    return policyNumber;
  }

  public void setPolicyNumber(Integer policyNumber) {
    this.policyNumber = policyNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserProfile userProfile = (UserProfile) o;
    return Objects.equals(this.emailAddress, userProfile.emailAddress) &&
        Objects.equals(this.firstName, userProfile.firstName) &&
        Objects.equals(this.lastName, userProfile.lastName) &&
        Objects.equals(this.middleName, userProfile.middleName) &&
        Objects.equals(this.dob, userProfile.dob) &&
        Objects.equals(this.policyNumber, userProfile.policyNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailAddress, firstName, lastName, middleName, dob, policyNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserProfile {\n");
    
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    dob: ").append(toIndentedString(dob)).append("\n");
    sb.append("    policyNumber: ").append(toIndentedString(policyNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

