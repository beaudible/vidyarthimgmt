package com.valmiki.vidyarthimgmt.repo;

import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public final class VidyarthiRepositoryTest {

    @Mock
    private VidyarthiRepository mockVidyarthiRepository;

    @Test
    public void testFindById(){

        Vidyarthi vidyarthi= Vidyarthi.builder()
                .id(1)
                .firstName("shubhi")
                .lastName("sharma")
                .email("sample@gmail.com")
                .build();
        when(mockVidyarthiRepository.findById(1)).thenReturn(Optional.of(vidyarthi));

        Optional<Vidyarthi> result = mockVidyarthiRepository.findById(1);

        assertTrue(result.isPresent());

        verify(mockVidyarthiRepository) .findById(1);

    }

    @Test
    public void testFindAll(){


        List<Vidyarthi> vidyarthi= new ArrayList<>();
        vidyarthi.add(Vidyarthi.builder()
                .id(1)
                .firstName("student 1")
                .lastName("sharma")
                .email("asd@gmail.com")
                .build());

        vidyarthi.add(Vidyarthi.builder()
                .id(2)
                .firstName("student 2")
                .lastName("Sample")
                .email("nh@gmail.com")
                .build());

        when(mockVidyarthiRepository.findAll()).thenReturn(vidyarthi);

        List<Vidyarthi> result = mockVidyarthiRepository.findAll();

        assertEquals(2, result.size());

        verify(mockVidyarthiRepository).findAll();

    }

    @Test
    public void testSave() {
        Vidyarthi vidyarthi = Vidyarthi.builder()
                .id(1)
                .firstName("student 1")
                .lastName(" surname")
                .email("shubhi@gmail.com")
                .build();
        when(mockVidyarthiRepository.save(vidyarthi)).thenReturn(vidyarthi);

        Vidyarthi savedVidyarthi = mockVidyarthiRepository.save(vidyarthi);

        assertNotNull(savedVidyarthi);
        assertEquals(1, savedVidyarthi.getId());

        verify(mockVidyarthiRepository).save(vidyarthi);
    }


}


