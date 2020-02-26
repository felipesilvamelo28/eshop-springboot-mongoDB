package com.felipe.eshop.cliente.repository;

import com.felipe.eshop.cliente.entity.Estado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String> {
}
