package com.felipe.eshop.categoria.service;

import com.felipe.eshop.categoria.entity.Categoria;
import com.felipe.eshop.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(String id){
        return categoriaRepository.findById(id).orElseThrow(()-> new RuntimeException("Categoria não encontrada!"));
    }
}
