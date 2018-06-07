package org.ugguss.generated.controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-06-06T20:33:45.267-04:00")

public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
