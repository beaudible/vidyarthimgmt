package com.valmiki.vidyarthimgmt.service;

import com.valmiki.vidyarthimgmt.dao.VidyarthiDAO;
import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VidyarthiServiceImpl  implements VidyarthiService {

    private VidyarthiDAO vidyarthiDAO;
@Autowired
    public VidyarthiServiceImpl(VidyarthiDAO vidyarthiDAO) {
        this.vidyarthiDAO = vidyarthiDAO;
    }

    @Override
    public List<Vidyarthi> findAll() {
        return vidyarthiDAO.findAll();
    }

    @Override
    public Vidyarthi findById(int theId) {
        return vidyarthiDAO.findById(theId);
    }
    @Transactional
    @Override
    public Vidyarthi save(Vidyarthi theVidyarthi) {
        return vidyarthiDAO.save(theVidyarthi);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {

    }
}