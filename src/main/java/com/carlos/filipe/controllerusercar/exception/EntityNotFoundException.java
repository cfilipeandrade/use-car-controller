package com.carlos.filipe.controllerusercar.exception;

public class EntityNotFoundException extends BusinessException{
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
