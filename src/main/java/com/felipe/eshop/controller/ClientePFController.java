package com.felipe.eshop.controller;

import com.felipe.eshop.entity.ClientePF;
import com.felipe.eshop.entity.Endereco;
import com.felipe.eshop.repository.ClientePFRepository;
import com.felipe.eshop.service.ClientePFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClientePFController {

    @Autowired
    ClientePFRepository clientePFRepository;
    @Autowired
    ClientePFService clientePFService;

    @GetMapping
    public List<ClientePF> listaClientesPF(){
        return clientePFRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ClientePF listaClientesPFById(@PathVariable String id){
        return clientePFService.findById(id);
    }

    @GetMapping(value = "/{id}/enderecos")
    public List<Endereco> listaEnderecoCliente(@PathVariable String id){
        ClientePF clientePF = clientePFService.findById(id);
        return clientePF.getEnderecos();
    }

}
