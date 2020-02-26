package com.felipe.eshop.repository;

import com.felipe.eshop.entity.Endereco;
import com.felipe.eshop.entity.Estado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String> {
}
