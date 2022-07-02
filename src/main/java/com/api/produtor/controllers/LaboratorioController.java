package com.api.produtor.controllers;

import com.api.produtor.models.LaboratorioModel;
import com.api.produtor.models.PropriedadeModel;
import com.api.produtor.services.LaboratorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/laboratorio")
public class LaboratorioController {
    final LaboratorioService laboratorioService;

    public LaboratorioController(LaboratorioService laboratorioService){
        this.laboratorioService = laboratorioService;
    }

    @GetMapping
    public ResponseEntity<List<LaboratorioModel>> getAllLaboratorios(){
        return ResponseEntity.status(HttpStatus.OK).body(laboratorioService.findAll());
    }
}
