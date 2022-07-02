package com.api.produtor.controllers;

import com.api.produtor.models.ProdutorModel;
import com.api.produtor.models.PropriedadeModel;
import com.api.produtor.services.ProdutorService;
import com.api.produtor.services.PropriedadeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/propriedade")
public class PropriedadeController {

    final PropriedadeService propriedadeService;

    public PropriedadeController(PropriedadeService propriedadeService) {
        this.propriedadeService = propriedadeService;
    }

    @GetMapping
    public ResponseEntity<List<PropriedadeModel>> getAllPropriedades(){
        return ResponseEntity.status(HttpStatus.OK).body(propriedadeService.findAll());
    }
}
