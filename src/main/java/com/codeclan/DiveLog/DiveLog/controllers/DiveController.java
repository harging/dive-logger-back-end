package com.codeclan.DiveLog.DiveLog.controllers;

import com.codeclan.DiveLog.DiveLog.models.Dive;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.CylinderRepository;
import com.codeclan.DiveLog.DiveLog.repositories.DiveRepository;
import com.codeclan.DiveLog.DiveLog.Utility;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

@RestController
public class DiveController {

    @Autowired
    DiveRepository diveRepository;

    @Autowired
    SamplePointRepository samplePointRepository;

    @Autowired
    CylinderRepository cylinderRepository;

    @GetMapping(value = "/dives")
    ResponseEntity<List<Dive>> getAllDives(){
        System.out.println(diveRepository.findAll().get(0).getCylinders());
        return new ResponseEntity<>(diveRepository.findByOrderByIdDesc(), HttpStatus.OK);
        //return new ResponseEntity<>(diveRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/dives/{id}")
    ResponseEntity <Optional<Dive>> getDiveById(@PathVariable Long id){
        return new ResponseEntity<>(diveRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/dives/{id}/profile")
    ResponseEntity <List<SamplePoint>> getProfileByDiveId(@PathVariable Long id){
        return new ResponseEntity<>(diveRepository.findById(id).get().getProfile(), HttpStatus.OK);
    }

    @PostMapping(value = "/uploaddives")
    public String loadDiveExcel( @RequestParam("excelfile") MultipartFile excelfile, Model model )
            throws IOException {
                //call your db class loader
                Utility utilities = new Utility(diveRepository, samplePointRepository, cylinderRepository);
                utilities.readFromExcelStream(excelfile.getBytes());

                return "Success";
    }

    @PostMapping(value = "/dives", consumes={"application/json"})
    public ResponseEntity<Dive> createDive(@RequestBody Dive newDive) {
        Dive dive = diveRepository.save(newDive);
            return new ResponseEntity<>(dive, HttpStatus.CREATED);
    }
    }
