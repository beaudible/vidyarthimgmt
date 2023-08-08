package com.valmiki.vidyarthimgmt.service;

import com.valmiki.vidyarthimgmt.entity.Vidyarthi;

import java.util.List;

public interface VidyarthiService{


    List<Vidyarthi> findAll();

        Vidyarthi findById(int theId);
        Vidyarthi save (Vidyarthi theVidyarthi);

        void deleteById(int theId);
}
