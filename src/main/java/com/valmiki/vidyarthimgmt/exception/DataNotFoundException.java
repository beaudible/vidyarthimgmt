package com.valmiki.vidyarthimgmt.exception;

public class DataNotFoundException extends  RuntimeException {


    private static final String message = "Data not found";
    public DataNotFoundException() {
        super(message);
    }
}
