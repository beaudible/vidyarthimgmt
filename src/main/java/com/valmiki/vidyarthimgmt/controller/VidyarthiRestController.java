package com.valmiki.vidyarthimgmt.controller;

import com.valmiki.vidyarthimgmt.entity.Vidyarthi;
import com.valmiki.vidyarthimgmt.service.VidyarthiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vidyarthi")
public class VidyarthiRestController {

    private VidyarthiService vidyarthiService;

    //inject employee dao
    @Autowired
    public VidyarthiRestController(VidyarthiService theVidyarthiService) {
        vidyarthiService = theVidyarthiService;
    }


    @GetMapping("/vidyarthi")
    public List<Vidyarthi> findAll() {
        return vidyarthiService.findAll();
    }

    //add mapping for GET
    @GetMapping("/vidyarthi/{vidyarthiId}")
    public Vidyarthi getVidyarthi(@PathVariable int vidyarthiId) {
        Vidyarthi theVidyarthi= vidyarthiService.findById(vidyarthiId);

        if (theVidyarthi== null) {
            throw new RuntimeException("id not found");

        }
        return theVidyarthi;
    }

    //add mapping for POST
    @PostMapping("/vidyarthi")
    public Vidyarthi addVidyarthi(@RequestBody Vidyarthi theVidyarthi) {
        theVidyarthi.setId(0);
        Vidyarthi dbVidyarthi = vidyarthiService.save(theVidyarthi);
        return dbVidyarthi;
    }

    //add mapping for PUT
    @PutMapping("/vidyarthi")
    public Vidyarthi updateVidyarthi(@RequestBody Vidyarthi theVidyarthi) {
        Vidyarthi dbVidyarthi = vidyarthiService.save(theVidyarthi);
        return dbVidyarthi;
    }

    //add mapping for DELETE
    @DeleteMapping("/vidyarthi/{vidyarthiId}")
    public String deleteVidyarthi(@PathVariable int vidyarthiId) {
        Vidyarthi tempVidyarthi=vidyarthiService.findById(vidyarthiId);

        if(tempVidyarthi==null){
            throw new RuntimeException("vidyarthi id not found");
        }

        vidyarthiService.deleteById(vidyarthiId);
        return ""+vidyarthiId;
    }
}
