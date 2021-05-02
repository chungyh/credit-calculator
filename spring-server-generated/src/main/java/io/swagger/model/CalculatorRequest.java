package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CalculatorRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-02T18:59:50.045Z[GMT]")


public class CalculatorRequest   {
  @JsonProperty("numberOfEmployees")
  private Integer numberOfEmployees = null;

  /**
   * Company Type
   */
  public enum CompanyTypeEnum {
    SOLE_PROPRIETORSHIP("Sole Proprietorship"),
    
    PARTNERSHIP("Partnership"),
    
    LIMITED_LIABILITY_COMPANY("Limited Liability Company"),
    
    OTHERS("Others");

    private String value;

    CompanyTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CompanyTypeEnum fromValue(String text) {
      for (CompanyTypeEnum b : CompanyTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("companyType")
  private CompanyTypeEnum companyType = null;

  @JsonProperty("numberOfYearsOperated")
  private Integer numberOfYearsOperated = null;

  public CalculatorRequest numberOfEmployees(Integer numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
    return this;
  }

  /**
   * Get numberOfEmployees
   * @return numberOfEmployees
   **/
  @Schema(description = "")
  
    public Integer getNumberOfEmployees() {
    return numberOfEmployees;
  }

  public void setNumberOfEmployees(Integer numberOfEmployees) {
    this.numberOfEmployees = numberOfEmployees;
  }

  public CalculatorRequest companyType(CompanyTypeEnum companyType) {
    this.companyType = companyType;
    return this;
  }

  /**
   * Company Type
   * @return companyType
   **/
  @Schema(description = "Company Type")
  
    public CompanyTypeEnum getCompanyType() {
    return companyType;
  }

  public void setCompanyType(CompanyTypeEnum companyType) {
    this.companyType = companyType;
  }

  public CalculatorRequest numberOfYearsOperated(Integer numberOfYearsOperated) {
    this.numberOfYearsOperated = numberOfYearsOperated;
    return this;
  }

  /**
   * Get numberOfYearsOperated
   * @return numberOfYearsOperated
   **/
  @Schema(description = "")
  
    public Integer getNumberOfYearsOperated() {
    return numberOfYearsOperated;
  }

  public void setNumberOfYearsOperated(Integer numberOfYearsOperated) {
    this.numberOfYearsOperated = numberOfYearsOperated;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatorRequest calculatorRequest = (CalculatorRequest) o;
    return Objects.equals(this.numberOfEmployees, calculatorRequest.numberOfEmployees) &&
        Objects.equals(this.companyType, calculatorRequest.companyType) &&
        Objects.equals(this.numberOfYearsOperated, calculatorRequest.numberOfYearsOperated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfEmployees, companyType, numberOfYearsOperated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatorRequest {\n");
    
    sb.append("    numberOfEmployees: ").append(toIndentedString(numberOfEmployees)).append("\n");
    sb.append("    companyType: ").append(toIndentedString(companyType)).append("\n");
    sb.append("    numberOfYearsOperated: ").append(toIndentedString(numberOfYearsOperated)).append("\n");
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
