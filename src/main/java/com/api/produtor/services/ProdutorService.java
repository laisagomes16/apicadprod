package com.api.produtor.services;

import com.api.produtor.models.ProdutorModel;
import com.api.produtor.repositories.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutorService {

    final ProdutorRepository produtorRepository;

    public ProdutorService(ProdutorRepository produtorRepository) {
        this.produtorRepository = produtorRepository;
    }

    @Transactional
    public ProdutorModel save(ProdutorModel produtorModel) {
        return produtorRepository.save(produtorModel);
    }

    public Page<ProdutorModel> findAll(Pageable pageable) {
        return produtorRepository.findAll(pageable);
    }

    @Transactional
    public void delete(ProdutorModel produtorModel) {
        produtorRepository.delete(produtorModel);
    }

    public Optional<ProdutorModel> findById(Integer id) {
        return produtorRepository.findById(id);
    }
}
