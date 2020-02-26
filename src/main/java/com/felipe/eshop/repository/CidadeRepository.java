package com.felipe.eshop.repository;

import com.felipe.eshop.entity.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {
}
