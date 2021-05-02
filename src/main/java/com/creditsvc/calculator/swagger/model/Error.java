package com.creditsvc.calculator.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Error
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-05T07:13:29.676Z")

public class Error   {
  @JsonProperty("logref")
  private String logref = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("path")
  private String path = null;

  public Error logref(String logref) {
    this.logref = logref;
    return this;
  }

   /**
   * The error code and reference for the error
   * @return logref
  **/
  public String getLogref() {
    return logref;
  }

  public void setLogref(String logref) {
    this.logref = logref;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

   /**
   * The description for the error
   * @return message
  **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error path(String path) {
    this.path = path;
    return this;
  }

   /**
   * For expressing a JSON Pointer (RFC6901) to a field in related resource (contained in the 'about' link relation) that this error is relevant for.
   * @return path
  **/
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.logref, error.logref) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.path, error.path);
  }

  @Override
  public int hashCode() {
    return Objects.hash(logref, message, path);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    logref: ").append(toIndentedString(logref)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
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

