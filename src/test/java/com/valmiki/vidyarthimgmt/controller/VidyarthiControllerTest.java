package com.valmiki.vidyarthimgmt.controller;

import com.valmiki.vidyarthimgmt.dto.request.VidyarthiRequest;
import com.valmiki.vidyarthimgmt.dto.response.VidyarthiResponse;
import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import com.valmiki.vidyarthimgmt.service.VidyarthiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest
public class VidyarthiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private VidyarthiService vidyarthiService;

    private List<Vidyarthi> vidyarthiList;

    @BeforeEach
    void setUp() {
        this.vidyarthiList = new ArrayList<>();
        this.vidyarthiList.add(new Vidyarthi(1, "student1", "sharma", "user@gmail.com"));
        this.vidyarthiList.add(new Vidyarthi(2, "student2", "sharma", "User2@gmail.com"));
        this.vidyarthiList.add(new Vidyarthi(3, "student3", "sharma", "User3@gmail.com"));

    }

    @Test
    void fetchAllUsers() throws Exception {
        List<VidyarthiResponse> vidyarthiResponses = new ArrayList<>();
        for (Vidyarthi vidyarthi : vidyarthiList) {
            vidyarthiResponses.add(VidyarthiResponse.builder()
                    .id(vidyarthi.getId())
                    .firstName(vidyarthi.getFirstName())
                    .lastName(vidyarthi.getLastName())
                    .email(vidyarthi.getEmail())
                    .build());
        }

        given(vidyarthiService.findAll()).willReturn(vidyarthiResponses);

        this.mockMvc.perform(get("/api/v1/vidyarthi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(vidyarthiList.size()));
    }

    @Test
    void userById() throws Exception {
        final int id = 1;
        final VidyarthiResponse vidyarthi = VidyarthiResponse.builder()
                .id(1)
                .firstName("shubhi")
                .lastName("sharma")
                .email("shg@gmail.com")
                .build();

        given(vidyarthiService.findByID(id)).willReturn(vidyarthi);

        this.mockMvc.perform(get("/api/v1/vidyarthi/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(vidyarthi.getEmail()))
                .andExpect(jsonPath("$.firstName").value(vidyarthi.getFirstName()));
    }

    @Test
    void createUser() throws Exception {

       VidyarthiRequest vidyarthiRequest=new VidyarthiRequest();
        VidyarthiResponse vidyarthiResponse =new VidyarthiResponse();
        vidyarthiRequest.setFirstName("shubhi");
        vidyarthiRequest.setLastName("sharma");
        vidyarthiRequest.setEmail("sh@gmail.com");
        vidyarthiResponse.setFirstName(vidyarthiRequest.getFirstName());
        vidyarthiResponse.setLastName(vidyarthiRequest.getLastName());
        vidyarthiResponse.setEmail(vidyarthiRequest.getEmail());
        when(vidyarthiService.save(any(VidyarthiRequest.class))).thenReturn(vidyarthiResponse);

        this.mockMvc.perform(post("/api/v1/vidyarthi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vidyarthiRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName",is(vidyarthiRequest.getFirstName())))
                .andExpect(jsonPath("$.lastName",is(vidyarthiRequest.getLastName())))
                .andExpect(jsonPath("$.email",is(vidyarthiRequest.getEmail())));

    }


}




