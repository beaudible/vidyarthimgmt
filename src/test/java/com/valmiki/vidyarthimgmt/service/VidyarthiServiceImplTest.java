package com.valmiki.vidyarthimgmt.service;

import com.valmiki.vidyarthimgmt.dto.request.VidyarthiRequest;
import com.valmiki.vidyarthimgmt.dto.response.VidyarthiResponse;
import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import com.valmiki.vidyarthimgmt.repo.VidyarthiRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VidyarthiServiceImplTest {

    @Mock
    private VidyarthiRepository mockvidyarthiRepository;

    @InjectMocks
    private VidyarthiServiceImpl vidyarthiService;

    private List<Vidyarthi> vidyarthi;

    @BeforeEach
    public void setup(){
        vidyarthi=new ArrayList<>();
        Vidyarthi vidyarthi1= Vidyarthi.builder()
                .id(1)
                .firstName("abc")
                .lastName("def")
                .email("jh@gmail.com")
                .build();

        Vidyarthi vidyarthi2= Vidyarthi.builder()
                .id(2)
                .firstName("ghi")
                .lastName("jkl")
                .email("lk@gmail.com")
                .build();

        vidyarthi.add(vidyarthi1);
        vidyarthi.add(vidyarthi2);
    }


    @Test
    public void testFindAll(){

       given( mockvidyarthiRepository.findAll()).willReturn(vidyarthi);
        List<VidyarthiResponse> result = vidyarthiService.findAll();
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void testFindById() {
        Vidyarthi vidyarthi = Vidyarthi.builder()
                .id(1)
                .firstName("Sample student")
                .lastName("Sample surname")
                .email("kjh@gmail.com")
                .build();
        when(mockvidyarthiRepository.findById(1)).thenReturn(Optional.of(vidyarthi));
        VidyarthiResponse result = vidyarthiService.findByID(1);
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(vidyarthi);
    }

    @Test
    public void testSave() {
        VidyarthiRequest vidyarthiRequest = VidyarthiRequest.builder()
                .firstName("Sample student")
                .lastName("Sample surname")
                .email("ku@gmail.com")
                .build();
        Vidyarthi savedVidyarthi = Vidyarthi.builder()
                .id(1)
                .firstName("Sample student")
                .lastName("Sample surname")
                .email("tr@gmail.com")
                .build();
        when(mockvidyarthiRepository.save(any())).thenReturn(savedVidyarthi);

        VidyarthiResponse vidyarthiResponse = vidyarthiService.save(vidyarthiRequest);


        assertNotNull(vidyarthiResponse);
        assertEquals(0, vidyarthiResponse.getId());

        verify(mockvidyarthiRepository).save(any());
    }











}
