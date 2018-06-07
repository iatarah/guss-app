package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.ugguss.generated.model.BaseResponse;
import org.ugguss.generated.model.Member;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MemberProfileResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T20:33:45.267-04:00")

public class MemberProfileResponse   {
  @JsonProperty("baseResponse")
  private BaseResponse baseResponse = null;

  @JsonProperty("gussMember")
  private Member gussMember = null;

  public MemberProfileResponse baseResponse(BaseResponse baseResponse) {
    this.baseResponse = baseResponse;
    return this;
  }

   /**
   * Get baseResponse
   * @return baseResponse
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BaseResponse getBaseResponse() {
    return baseResponse;
  }

  public void setBaseResponse(BaseResponse baseResponse) {
    this.baseResponse = baseResponse;
  }

  public MemberProfileResponse gussMember(Member gussMember) {
    this.gussMember = gussMember;
    return this;
  }

   /**
   * Get gussMember
   * @return gussMember
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Member getGussMember() {
    return gussMember;
  }

  public void setGussMember(Member gussMember) {
    this.gussMember = gussMember;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MemberProfileResponse memberProfileResponse = (MemberProfileResponse) o;
    return Objects.equals(this.baseResponse, memberProfileResponse.baseResponse) &&
        Objects.equals(this.gussMember, memberProfileResponse.gussMember);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseResponse, gussMember);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MemberProfileResponse {\n");
    
    sb.append("    baseResponse: ").append(toIndentedString(baseResponse)).append("\n");
    sb.append("    gussMember: ").append(toIndentedString(gussMember)).append("\n");
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

