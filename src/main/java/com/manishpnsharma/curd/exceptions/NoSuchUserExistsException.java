package com.manishpnsharma.curd.exceptions;

import java.io.Serial;

public class NoSuchUserExistsException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NoSuchUserExistsException() {
        super();
    }

    public NoSuchUserExistsException(String msg) {
        super(msg);
    }
}