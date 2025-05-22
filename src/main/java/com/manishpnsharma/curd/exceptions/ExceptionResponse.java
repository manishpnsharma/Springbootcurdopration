package com.manishpnsharma.curd.exceptions;
public class ExceptionResponse {
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    private String errorMessage;
    public String getRequestedURI() {
        return requestedURI;
    }
    public void callerURL(final String requestedURI) {
        this.requestedURI = requestedURI;
    }
    private String requestedURI;
}
