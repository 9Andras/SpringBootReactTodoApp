package com.gdn.fullstack.SpringBootReactTodoApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class ExistingUserException extends RuntimeException{
    public ExistingUserException(String message) {
        super(message);
    }
}
