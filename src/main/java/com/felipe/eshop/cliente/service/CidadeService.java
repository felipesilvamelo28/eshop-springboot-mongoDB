package com.felipe.eshop.cliente.service;

import com.felipe.eshop.cliente.entity.Cidade;
import com.felipe.eshop.cliente.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    public Cidade findByNome(String text){
        return cidadeRepository.findByNome(text);
    }

}
