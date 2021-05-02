package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CalculatorResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-05-02T18:59:50.045Z[GMT]")


public class CalculatorResponse   {
  @JsonProperty("creditScore")
  private Long creditScore = null;

  public CalculatorResponse creditScore(Long creditScore) {
    this.creditScore = creditScore;
    return this;
  }

  /**
   * Credit Score
   * @return creditScore
   **/
  @Schema(description = "Credit Score")
  
    public Long getCreditScore() {
    return creditScore;
  }

  public void setCreditScore(Long creditScore) {
    this.creditScore = creditScore;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalculatorResponse calculatorResponse = (CalculatorResponse) o;
    return Objects.equals(this.creditScore, calculatorResponse.creditScore);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creditScore);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalculatorResponse {\n");
    
    sb.append("    creditScore: ").append(toIndentedString(creditScore)).append("\n");
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
