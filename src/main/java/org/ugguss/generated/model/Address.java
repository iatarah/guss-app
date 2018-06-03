package org.ugguss.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Address
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-03T00:59:47.813-04:00")

public class Address   {
  @JsonProperty("street1")
  private String street1 = null;

  @JsonProperty("street2")
  private String street2 = null;

  @JsonProperty("street3")
  private String street3 = null;

  @JsonProperty("zip")
  private String zip = null;

  @JsonProperty("pObox")
  private String pObox = null;

  @JsonProperty("region")
  private String region = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("primary")
  private String primary = null;

  @JsonProperty("mailing")
  private String mailing = null;

  public Address street1(String street1) {
    this.street1 = street1;
    return this;
  }

   /**
   * Get street1
   * @return street1
  **/
  @ApiModelProperty(value = "")


  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public Address street2(String street2) {
    this.street2 = street2;
    return this;
  }

   /**
   * Get street2
   * @return street2
  **/
  @ApiModelProperty(value = "")


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  public Address street3(String street3) {
    this.street3 = street3;
    return this;
  }

   /**
   * Get street3
   * @return street3
  **/
  @ApiModelProperty(value = "")


  public String getStreet3() {
    return street3;
  }

  public void setStreet3(String street3) {
    this.street3 = street3;
  }

  public Address zip(String zip) {
    this.zip = zip;
    return this;
  }

   /**
   * Get zip
   * @return zip
  **/
  @ApiModelProperty(value = "")


  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public Address pObox(String pObox) {
    this.pObox = pObox;
    return this;
  }

   /**
   * Get pObox
   * @return pObox
  **/
  @ApiModelProperty(value = "")


  public String getPObox() {
    return pObox;
  }

  public void setPObox(String pObox) {
    this.pObox = pObox;
  }

  public Address region(String region) {
    this.region = region;
    return this;
  }

   /**
   * Get region
   * @return region
  **/
  @ApiModelProperty(value = "")


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Address country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Address primary(String primary) {
    this.primary = primary;
    return this;
  }

   /**
   * Get primary
   * @return primary
  **/
  @ApiModelProperty(value = "")


  public String getPrimary() {
    return primary;
  }

  public void setPrimary(String primary) {
    this.primary = primary;
  }

  public Address mailing(String mailing) {
    this.mailing = mailing;
    return this;
  }

   /**
   * Get mailing
   * @return mailing
  **/
  @ApiModelProperty(value = "")


  public String getMailing() {
    return mailing;
  }

  public void setMailing(String mailing) {
    this.mailing = mailing;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Address address = (Address) o;
    return Objects.equals(this.street1, address.street1) &&
        Objects.equals(this.street2, address.street2) &&
        Objects.equals(this.street3, address.street3) &&
        Objects.equals(this.zip, address.zip) &&
        Objects.equals(this.pObox, address.pObox) &&
        Objects.equals(this.region, address.region) &&
        Objects.equals(this.country, address.country) &&
        Objects.equals(this.primary, address.primary) &&
        Objects.equals(this.mailing, address.mailing);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street1, street2, street3, zip, pObox, region, country, primary, mailing);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Address {\n");
    
    sb.append("    street1: ").append(toIndentedString(street1)).append("\n");
    sb.append("    street2: ").append(toIndentedString(street2)).append("\n");
    sb.append("    street3: ").append(toIndentedString(street3)).append("\n");
    sb.append("    zip: ").append(toIndentedString(zip)).append("\n");
    sb.append("    pObox: ").append(toIndentedString(pObox)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    primary: ").append(toIndentedString(primary)).append("\n");
    sb.append("    mailing: ").append(toIndentedString(mailing)).append("\n");
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

