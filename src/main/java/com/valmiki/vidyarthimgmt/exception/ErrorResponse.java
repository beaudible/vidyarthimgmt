package com.valmiki.vidyarthimgmt.exception;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private int code;
    private String message;
}
