package com.felipe.eshop.categoria.repository;

import com.felipe.eshop.categoria.entity.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
