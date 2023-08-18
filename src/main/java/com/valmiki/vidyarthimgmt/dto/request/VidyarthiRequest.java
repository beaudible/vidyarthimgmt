package com.valmiki.vidyarthimgmt.dto.request;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VidyarthiRequest {

    private int id;

    private String firstName;

    private String lastName;

    private String email;
}
