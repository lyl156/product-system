package com.example.crud.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8502434632132858009L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String mess) {
        super(mess);
    }

    public NotFoundException(String mess, Throwable cause) {
        super(mess, cause);
    }
}
