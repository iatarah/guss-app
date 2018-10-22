package org.ugguss.httpentities;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseMessage {
    @ApiModelProperty(value="Indication of whether the request was successful or not", required = true)
    private Boolean success;

    @ApiModelProperty(value="message value")
    private String message;

    @ApiModelProperty(value="error message if there was an error")
    private String error;

    @ApiModelProperty(value = "status code if there was an error")
    private int statusCode;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
