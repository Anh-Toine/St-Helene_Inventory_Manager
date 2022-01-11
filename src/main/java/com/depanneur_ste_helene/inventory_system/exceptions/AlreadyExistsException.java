package com.depanneur_ste_helene.inventory_system.exceptions;
import org.springframework.web.bind.annotation.ResponseStatus;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@ResponseStatus(UNPROCESSABLE_ENTITY)
public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(){}

    public AlreadyExistsException(String message){
        super(message);
    }

    public AlreadyExistsException(Throwable cause){
        super(cause);
    }

    public AlreadyExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
