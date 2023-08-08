package com.valmiki.vidyarthimgmt.dao;
import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import java.util.List;

public interface VidyarthiDAO {

    List<Vidyarthi> findAll();

    Vidyarthi findById(int theId);
    Vidyarthi save (Vidyarthi theVidyarthi);

    void deleteById(int theId);
}
