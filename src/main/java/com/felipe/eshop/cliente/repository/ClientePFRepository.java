package com.felipe.eshop.cliente.repository;

import com.felipe.eshop.cliente.entity.ClientePF;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePFRepository extends MongoRepository<ClientePF, String> {
}
