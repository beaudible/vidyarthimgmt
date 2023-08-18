package com.valmiki.vidyarthimgmt.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VidyarthiResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

}
