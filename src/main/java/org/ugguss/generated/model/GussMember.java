package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.ugguss.generated.model.Address;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GussMember
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:45:47.270-05:00")

public class GussMember   {
  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("memberId")
  private String memberId = null;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth = null;

  /**
   * Gets or Sets gender
   */
  public enum GenderEnum {
    MALE("male"),
    
    FEMALE("female");

    private String value;

    GenderEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static GenderEnum fromValue(String text) {
      for (GenderEnum b : GenderEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("gender")
  private GenderEnum gender = null;

  @JsonProperty("retirementDate")
  private String retirementDate = null;

  /**
   * Gets or Sets membershipStatus
   */
  public enum MembershipStatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

    private String value;

    MembershipStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MembershipStatusEnum fromValue(String text) {
      for (MembershipStatusEnum b : MembershipStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("membershipStatus")
  private MembershipStatusEnum membershipStatus = null;

  @JsonProperty("basicSalary")
  private BigDecimal basicSalary = null;

  @JsonProperty("address")
  private Address address = null;

  public GussMember userId(String userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public GussMember memberId(String memberId) {
    this.memberId = memberId;
    return this;
  }

   /**
   * Get memberId
   * @return memberId
  **/
  @ApiModelProperty(value = "")


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public GussMember dateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
    return this;
  }

   /**
   * Get dateOfBirth
   * @return dateOfBirth
  **/
  @ApiModelProperty(value = "")


  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public GussMember gender(GenderEnum gender) {
    this.gender = gender;
    return this;
  }

   /**
   * Get gender
   * @return gender
  **/
  @ApiModelProperty(value = "")


  public GenderEnum getGender() {
    return gender;
  }

  public void setGender(GenderEnum gender) {
    this.gender = gender;
  }

  public GussMember retirementDate(String retirementDate) {
    this.retirementDate = retirementDate;
    return this;
  }

   /**
   * Get retirementDate
   * @return retirementDate
  **/
  @ApiModelProperty(value = "")


  public String getRetirementDate() {
    return retirementDate;
  }

  public void setRetirementDate(String retirementDate) {
    this.retirementDate = retirementDate;
  }

  public GussMember membershipStatus(MembershipStatusEnum membershipStatus) {
    this.membershipStatus = membershipStatus;
    return this;
  }

   /**
   * Get membershipStatus
   * @return membershipStatus
  **/
  @ApiModelProperty(value = "")


  public MembershipStatusEnum getMembershipStatus() {
    return membershipStatus;
  }

  public void setMembershipStatus(MembershipStatusEnum membershipStatus) {
    this.membershipStatus = membershipStatus;
  }

  public GussMember basicSalary(BigDecimal basicSalary) {
    this.basicSalary = basicSalary;
    return this;
  }

   /**
   * Get basicSalary
   * @return basicSalary
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getBasicSalary() {
    return basicSalary;
  }

  public void setBasicSalary(BigDecimal basicSalary) {
    this.basicSalary = basicSalary;
  }

  public GussMember address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GussMember gussMember = (GussMember) o;
    return Objects.equals(this.userId, gussMember.userId) &&
        Objects.equals(this.memberId, gussMember.memberId) &&
        Objects.equals(this.dateOfBirth, gussMember.dateOfBirth) &&
        Objects.equals(this.gender, gussMember.gender) &&
        Objects.equals(this.retirementDate, gussMember.retirementDate) &&
        Objects.equals(this.membershipStatus, gussMember.membershipStatus) &&
        Objects.equals(this.basicSalary, gussMember.basicSalary) &&
        Objects.equals(this.address, gussMember.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, memberId, dateOfBirth, gender, retirementDate, membershipStatus, basicSalary, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GussMember {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    memberId: ").append(toIndentedString(memberId)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    retirementDate: ").append(toIndentedString(retirementDate)).append("\n");
    sb.append("    membershipStatus: ").append(toIndentedString(membershipStatus)).append("\n");
    sb.append("    basicSalary: ").append(toIndentedString(basicSalary)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

