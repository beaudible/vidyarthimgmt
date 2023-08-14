package com.valmiki.vidyarthimgmt.exception;

public class DataNotFoundException extends  RuntimeException {

    public DataNotFoundException() {
        super("Data not found");
    }
}
