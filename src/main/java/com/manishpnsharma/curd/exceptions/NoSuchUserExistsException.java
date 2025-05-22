package com.manishpnsharma.curd.exceptions;

import java.io.Serial;

public class NoSuchUserExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private String errorCode;
    private String errorMessage;

    public Long getInput() {
        return input;
    }

    public void setInput(Long input) {
        this.input = input;
    }

    private Long input;

    public NoSuchUserExistsException(Long input, String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.input = input;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
