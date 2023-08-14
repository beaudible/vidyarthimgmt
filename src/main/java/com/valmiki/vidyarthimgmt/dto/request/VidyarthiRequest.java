package com.valmiki.vidyarthimgmt.dto.request;

import lombok.Builder;
import lombok.Data;
@Builder
@Data
public class VidyarthiRequest {

    private int id;

    private String firstName;

    private String lastName;

    private String email;
}
