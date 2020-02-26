package com.felipe.eshop.cliente.repository;

import com.felipe.eshop.cliente.entity.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends MongoRepository<Telefone, String> {
}
