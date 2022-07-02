package com.api.produtor.services;

import com.api.produtor.models.LaboratorioModel;
import com.api.produtor.models.ProdutorModel;
import com.api.produtor.repositories.LaboratorioRepository;
import com.api.produtor.repositories.ProdutorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LaboratorioService {
    final LaboratorioRepository laboratorioRepository;

    public LaboratorioService(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @Transactional
    public LaboratorioModel save(LaboratorioModel laboratorioModel) {
        return laboratorioRepository.save(laboratorioModel);
    }

    public List<LaboratorioModel> findAll() {
        return laboratorioRepository.findAll();
    }

    public Optional<LaboratorioModel> findById(int id) {
        return laboratorioRepository.findById(id);
    }

    @Transactional
    public void delete(LaboratorioModel laboratorioModel) {
        laboratorioRepository.delete(laboratorioModel);
    }
}
