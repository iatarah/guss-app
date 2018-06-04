package org.ugguss.generated.controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-04T14:37:17.942-05:00")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
