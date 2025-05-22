package com.manishpnsharma.curd.exceptions;

import brave.http.HttpServerRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchUserExistsException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
   public ExceptionResponse noSuchUserExistsException(final NoSuchUserExistsException noSuchUserExistsException, @NotNull final HttpServerRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setErrorMessage(noSuchUserExistsException.getMessage());
        exceptionResponse.callerURL(request.url());
        return exceptionResponse;
    }

}