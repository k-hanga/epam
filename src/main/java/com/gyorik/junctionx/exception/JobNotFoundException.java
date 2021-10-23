package com.gyorik.junctionx.exception;

public class JobNotFoundException extends RuntimeException {

    public JobNotFoundException(Long id) {
        super("Could not find job " + id);
    }
}