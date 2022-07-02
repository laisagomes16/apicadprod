package com.api.produtor.repositories;

import com.api.produtor.models.PropriedadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PropriedadeRepository extends JpaRepository<PropriedadeModel, Integer> {
}
