package com.felipe.eshop.repository;

import com.felipe.eshop.entity.Cidade;
import com.felipe.eshop.entity.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends MongoRepository<Telefone, String> {
}
