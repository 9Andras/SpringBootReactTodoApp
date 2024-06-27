package com.gdn.fullstack.SpringBootReactTodoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class ExistingEmailException extends RuntimeException {
    public ExistingEmailException(String message) {
        super(message);
    }
}
