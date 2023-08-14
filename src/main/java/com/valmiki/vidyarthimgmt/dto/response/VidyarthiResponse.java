package com.valmiki.vidyarthimgmt.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VidyarthiResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String email;
}
