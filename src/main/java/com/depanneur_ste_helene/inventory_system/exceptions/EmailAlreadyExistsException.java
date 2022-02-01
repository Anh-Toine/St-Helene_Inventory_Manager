package com.depanneur_ste_helene.inventory_system.exceptions;


public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
