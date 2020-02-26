package com.felipe.eshop.cliente.repository;

import com.felipe.eshop.cliente.entity.Cidade;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {
}
