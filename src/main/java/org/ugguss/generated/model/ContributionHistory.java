package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ContributionHistory
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T20:50:06.616-04:00")

public class ContributionHistory   {
  @JsonProperty("documentId")
  private String documentId = null;

  @JsonProperty("contributionStartDate")
  private String contributionStartDate = null;

  @JsonProperty("paymentDate")
  private String paymentDate = null;

  @JsonProperty("fiscalMonthYear")
  private String fiscalMonthYear = null;

  public ContributionHistory documentId(String documentId) {
    this.documentId = documentId;
    return this;
  }

   /**
   * Get documentId
   * @return documentId
  **/
  @ApiModelProperty(value = "")


  public String getDocumentId() {
    return documentId;
  }

  public void setDocumentId(String documentId) {
    this.documentId = documentId;
  }

  public ContributionHistory contributionStartDate(String contributionStartDate) {
    this.contributionStartDate = contributionStartDate;
    return this;
  }

   /**
   * Get contributionStartDate
   * @return contributionStartDate
  **/
  @ApiModelProperty(value = "")


  public String getContributionStartDate() {
    return contributionStartDate;
  }

  public void setContributionStartDate(String contributionStartDate) {
    this.contributionStartDate = contributionStartDate;
  }

  public ContributionHistory paymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
    return this;
  }

   /**
   * Get paymentDate
   * @return paymentDate
  **/
  @ApiModelProperty(value = "")


  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  public ContributionHistory fiscalMonthYear(String fiscalMonthYear) {
    this.fiscalMonthYear = fiscalMonthYear;
    return this;
  }

   /**
   * Get fiscalMonthYear
   * @return fiscalMonthYear
  **/
  @ApiModelProperty(value = "")


  public String getFiscalMonthYear() {
    return fiscalMonthYear;
  }

  public void setFiscalMonthYear(String fiscalMonthYear) {
    this.fiscalMonthYear = fiscalMonthYear;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContributionHistory contributionHistory = (ContributionHistory) o;
    return Objects.equals(this.documentId, contributionHistory.documentId) &&
        Objects.equals(this.contributionStartDate, contributionHistory.contributionStartDate) &&
        Objects.equals(this.paymentDate, contributionHistory.paymentDate) &&
        Objects.equals(this.fiscalMonthYear, contributionHistory.fiscalMonthYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(documentId, contributionStartDate, paymentDate, fiscalMonthYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContributionHistory {\n");
    
    sb.append("    documentId: ").append(toIndentedString(documentId)).append("\n");
    sb.append("    contributionStartDate: ").append(toIndentedString(contributionStartDate)).append("\n");
    sb.append("    paymentDate: ").append(toIndentedString(paymentDate)).append("\n");
    sb.append("    fiscalMonthYear: ").append(toIndentedString(fiscalMonthYear)).append("\n");
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

