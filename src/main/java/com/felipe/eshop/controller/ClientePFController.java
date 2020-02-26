package com.felipe.eshop.controller;

import com.felipe.eshop.entity.ClientePF;
import com.felipe.eshop.repository.ClientePFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClientePFController {

    @Autowired
    ClientePFRepository clientePFRepository;

    @GetMapping
    public List<ClientePF> listaClientesPF(){
        return clientePFRepository.findAll();
    }

}
