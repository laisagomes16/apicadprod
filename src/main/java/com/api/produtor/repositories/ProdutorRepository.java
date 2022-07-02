package com.api.produtor.repositories;

import com.api.produtor.models.ProdutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutorRepository extends JpaRepository<ProdutorModel, Integer> {


}
