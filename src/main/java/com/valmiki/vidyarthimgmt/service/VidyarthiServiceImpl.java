package com.valmiki.vidyarthimgmt.service;

import com.valmiki.vidyarthimgmt.dto.request.VidyarthiRequest;
import com.valmiki.vidyarthimgmt.dto.response.VidyarthiResponse;
import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import com.valmiki.vidyarthimgmt.exception.DataNotFoundException;
import com.valmiki.vidyarthimgmt.repo.VidyarthiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class VidyarthiServiceImpl implements VidyarthiService {
    @Autowired
    private VidyarthiRepository vidyarthiRepository;

    @Override
    public List<VidyarthiResponse> findAll() {
        List<Vidyarthi> vidyarthiList = vidyarthiRepository.findAll();

        return vidyarthiList.stream()
                .map(e -> VidyarthiResponse.builder()
                        .id(e.getId())
                        .firstName(e.getFirstName())
                        .lastName(e.getLastName())
                        .email(e.getEmail())
                        .build()).toList();
    }

    @Override
    public VidyarthiResponse findByID(int theId) {
        Optional<Vidyarthi> result = vidyarthiRepository.findById(theId);
        Vidyarthi theVidyarthi;
        if (result.isPresent()) {
            theVidyarthi = result.get();
        } else {
            throw new DataNotFoundException();
        }
        return VidyarthiResponse.builder()
                .id(theVidyarthi.getId())
                .firstName(theVidyarthi.getFirstName())
                .lastName(theVidyarthi.getLastName())
                .email(theVidyarthi.getEmail())
                .build();

    }

    @Override
    public VidyarthiResponse save(VidyarthiRequest vidyarthiRequest) {
        Vidyarthi vidyarthi = Vidyarthi.builder()
                .firstName(vidyarthiRequest.getFirstName())
                .lastName(vidyarthiRequest.getLastName())
                .email(vidyarthiRequest.getEmail())
                .build();
        vidyarthiRepository.save(vidyarthi);
        return VidyarthiResponse.builder()
                .id(vidyarthi.getId())
                .firstName(vidyarthi.getFirstName())
                .lastName(vidyarthi.getLastName())
                .email(vidyarthi.getEmail())
                .build();
    }

    @Override
    public VidyarthiResponse deleteById(int theId) {
        return null;
    }

}
