package org.ugguss.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.ugguss.httpentities.ResponseMessage;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> exceptionHandler(HttpServletRequest request, Exception ex) {
        String msg = ex.getMessage();
        ResponseMessage responseMessage = getErrorResponseMessage(request, msg, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<ResponseMessage>(responseMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    ResponseMessage getErrorResponseMessage(HttpServletRequest request, String msg, HttpStatus status)
    {
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setError(msg);
        responseMessage.setStatusCode(status.value());
        responseMessage.setSuccess(false);
        return responseMessage;
    }
}
