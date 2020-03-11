package com.webservices.project.services.exceptions;

import javax.annotation.Resource;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. ID = " + id);
    }
}
