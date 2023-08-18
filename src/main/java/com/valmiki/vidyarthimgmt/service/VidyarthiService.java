package com.valmiki.vidyarthimgmt.service;

import com.valmiki.vidyarthimgmt.dto.request.VidyarthiRequest;
import com.valmiki.vidyarthimgmt.dto.response.VidyarthiResponse;

import java.util.List;

public interface VidyarthiService {

    List<VidyarthiResponse> findAll();

    VidyarthiResponse findByID(int theId);

    VidyarthiResponse save(VidyarthiRequest vidyarthiRequest);

    VidyarthiResponse deleteById(int theId);
}
