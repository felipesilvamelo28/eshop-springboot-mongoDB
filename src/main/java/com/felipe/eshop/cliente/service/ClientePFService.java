package com.felipe.eshop.cliente.service;

import com.felipe.eshop.cliente.entity.ClientePF;
import com.felipe.eshop.cliente.repository.ClientePFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientePFService {

    @Autowired
    ClientePFRepository repository;

    public ClientePF findById(String id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado!"));
    }

}
