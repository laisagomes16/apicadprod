package com.api.produtor.services;

import com.api.produtor.models.LaboratorioModel;
import com.api.produtor.models.ProdutorModel;
import com.api.produtor.models.PropriedadeModel;
import com.api.produtor.repositories.ProdutorRepository;
import com.api.produtor.repositories.PropriedadeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PropriedadeService {
    final PropriedadeRepository propriedadeRepository;

    public PropriedadeService(PropriedadeRepository propriedadeRepository) {
        this.propriedadeRepository = propriedadeRepository;
    }

    @Transactional
    public PropriedadeModel save(PropriedadeModel propriedadeModel) {
        return propriedadeRepository.save(propriedadeModel);
    }

    public List<PropriedadeModel> findAll() {
        return propriedadeRepository.findAll();
    }

    public Optional<PropriedadeModel> findById(int id) {
        return propriedadeRepository.findById(id);
    }
}
