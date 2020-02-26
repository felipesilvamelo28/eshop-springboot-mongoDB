package com.felipe.eshop.repository;

import com.felipe.eshop.entity.Cidade;
import com.felipe.eshop.entity.ClientePF;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePFRepository extends MongoRepository<ClientePF, String> {
}
