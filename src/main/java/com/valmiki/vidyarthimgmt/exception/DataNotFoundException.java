package com.valmiki.vidyarthimgmt.exception;

public class DataNotFoundException extends  RuntimeException {


     private static final String MESSAGE = "Data Not Found";
    public DataNotFoundException() {
        super(MESSAGE);
    }
}
