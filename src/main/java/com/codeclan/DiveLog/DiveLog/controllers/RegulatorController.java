package com.codeclan.DiveLog.DiveLog.controllers;

import com.codeclan.DiveLog.DiveLog.models.Regulator;
import com.codeclan.DiveLog.DiveLog.models.SamplePoint;
import com.codeclan.DiveLog.DiveLog.repositories.RegulatorRepository;
import com.codeclan.DiveLog.DiveLog.repositories.SamplePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RegulatorController {
    @Autowired
    RegulatorRepository regulatorRepository;

    @GetMapping(value = "/regulators")
    ResponseEntity<List<Regulator>> getAllRegulators(){
        return new ResponseEntity<>(regulatorRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/regulators/{id}")
    ResponseEntity<Optional<Regulator>> getRegulatorById(@PathVariable Long id){
        return new ResponseEntity<>(regulatorRepository.findById(id), HttpStatus.OK);
    }
}
