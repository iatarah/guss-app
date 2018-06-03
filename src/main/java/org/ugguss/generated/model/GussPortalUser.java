package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GussPortalUser
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-02T16:45:47.270-05:00")

public class GussPortalUser   {
  @JsonProperty("emailAddress")
  private String emailAddress = null;

  @JsonProperty("screenName")
  private String screenName = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("active")
  private Boolean active = false;

  @JsonProperty("defaultUser")
  private Boolean defaultUser = false;

  public GussPortalUser emailAddress(String emailAddress) {
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

  public GussPortalUser screenName(String screenName) {
    this.screenName = screenName;
    return this;
  }

   /**
   * Get screenName
   * @return screenName
  **/
  @ApiModelProperty(value = "")


  public String getScreenName() {
    return screenName;
  }

  public void setScreenName(String screenName) {
    this.screenName = screenName;
  }

  public GussPortalUser id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public GussPortalUser active(Boolean active) {
    this.active = active;
    return this;
  }

   /**
   * Get active
   * @return active
  **/
  @ApiModelProperty(value = "")


  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public GussPortalUser defaultUser(Boolean defaultUser) {
    this.defaultUser = defaultUser;
    return this;
  }

   /**
   * Get defaultUser
   * @return defaultUser
  **/
  @ApiModelProperty(value = "")


  public Boolean getDefaultUser() {
    return defaultUser;
  }

  public void setDefaultUser(Boolean defaultUser) {
    this.defaultUser = defaultUser;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GussPortalUser gussPortalUser = (GussPortalUser) o;
    return Objects.equals(this.emailAddress, gussPortalUser.emailAddress) &&
        Objects.equals(this.screenName, gussPortalUser.screenName) &&
        Objects.equals(this.id, gussPortalUser.id) &&
        Objects.equals(this.active, gussPortalUser.active) &&
        Objects.equals(this.defaultUser, gussPortalUser.defaultUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emailAddress, screenName, id, active, defaultUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GussPortalUser {\n");
    
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
    sb.append("    screenName: ").append(toIndentedString(screenName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    defaultUser: ").append(toIndentedString(defaultUser)).append("\n");
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

