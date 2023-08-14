package com.valmiki.vidyarthimgmt.controller;

import com.valmiki.vidyarthimgmt.dto.request.VidyarthiRequest;
import com.valmiki.vidyarthimgmt.dto.response.VidyarthiResponse;
import com.valmiki.vidyarthimgmt.service.VidyarthiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vidyarthi")
public class VidyarthiController {
    @Autowired
    private VidyarthiService vidyarthiService;



    @GetMapping
    public ResponseEntity<List<VidyarthiResponse>> listVidyarthi() {
        return ResponseEntity.ok(vidyarthiService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VidyarthiResponse> getVidyarthiById(@PathVariable int id) {
        return ResponseEntity.ok(vidyarthiService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<VidyarthiResponse> addVidyarthi(@RequestBody VidyarthiRequest vidyarthiRequest) {
        return ResponseEntity.ok(vidyarthiService.save(vidyarthiRequest));
    }

    @PutMapping("/vidyarthi")
    public ResponseEntity<VidyarthiResponse> updateVidyarthi(@RequestBody VidyarthiRequest vidyarthiRequest) {
        return ResponseEntity.ok(vidyarthiService.save(vidyarthiRequest));
    }
   /* @DeleteMapping("/vidyarthi/{vidyarthiId}")
    public ResponseEntity<VidyarthiResponse> deleteVidyarthi(@PathVariable int id) {
        ResponseEntity.ok(vidyarthiService.findByID(id));

        if (tempVidyarthi == null) {
            throw new RuntimeException("vidyarthi id not found");
        }

        vidyarthiService.deleteById(vidyarthiId);
        return "" + vidyarthiId;
    }*/
}
