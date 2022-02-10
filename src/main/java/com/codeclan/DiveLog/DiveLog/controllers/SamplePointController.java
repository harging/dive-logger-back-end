package com.codeclan.DiveLog.DiveLog.controllers;

import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SamplePointController {

    @Autowired
    SamplePointRepository samplePointRepository;

    @GetMapping(value = "/samplepoints")
    ResponseEntity<List<SamplePoint>> getAllSamplePoints(){
        return new ResponseEntity<>(samplePointRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/samplepoints/bydiveid")
    public ResponseEntity<List<SamplePoint>> getPiratesByRaidsId(@RequestParam(name = "diveid") Long id){
        return new ResponseEntity<>(samplePointRepository.findByDiveId(id),HttpStatus.OK);
    }
}
