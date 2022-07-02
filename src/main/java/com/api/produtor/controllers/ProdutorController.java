package com.api.produtor.controllers;

import com.api.produtor.dtos.ProdutorDto;
import com.api.produtor.models.LaboratorioModel;
import com.api.produtor.models.ProdutorModel;
import com.api.produtor.models.PropriedadeModel;
import com.api.produtor.services.ProdutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produtor")
public class ProdutorController {

    final ProdutorService produtorService;

    public ProdutorController(ProdutorService produtorService) {
        this.produtorService = produtorService;
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ProdutorDto produtorDto){
        var produtorModel = new ProdutorModel();
        var laboratorioModel = new LaboratorioModel();
        var propriedadeModel = new PropriedadeModel();
        BeanUtils.copyProperties(produtorDto, produtorModel);
        BeanUtils.copyProperties(produtorDto.getLaboratorio(), laboratorioModel);
        BeanUtils.copyProperties(produtorDto.getInfosPropriedade(), propriedadeModel);

        produtorModel.setLaboratorio(laboratorioModel);
        produtorModel.setInfosPropriedade(propriedadeModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtorService.save(produtorModel));
    }

    @GetMapping
    public ResponseEntity<Page<ProdutorModel>> getAllProdutores(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(produtorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProdutor(@PathVariable(value = "id") Integer id){
        Optional<ProdutorModel> produtorModelOptional = produtorService.findById(id);
        if(!produtorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produtor not found"+id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(produtorModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") Integer id){
        Optional<ProdutorModel> produtorModelOptional = produtorService.findById(id);
        if (!produtorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produtor not found.");
        }
        produtorService.delete(produtorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Produtor deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") Integer id,
                                                    @RequestBody @Valid ProdutorDto produtorDto){
        Optional<ProdutorModel> produtorModelOptional = produtorService.findById(id);
        if (!produtorModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produtor not found.");
        }
        var produtorModel = new ProdutorModel();
        var laboratorioModel = new LaboratorioModel();
        var propriedadeModel = new PropriedadeModel();
        BeanUtils.copyProperties(produtorDto, produtorModel);
        BeanUtils.copyProperties(produtorDto.getLaboratorio(), laboratorioModel);
        BeanUtils.copyProperties(produtorDto.getInfosPropriedade(), propriedadeModel);

        produtorModel.setId(produtorModelOptional.get().getId());
        produtorModel.setLaboratorio(laboratorioModel);
        produtorModel.setInfosPropriedade(propriedadeModel);

        return ResponseEntity.status(HttpStatus.OK).body(produtorService.save(produtorModel));
    }



}
