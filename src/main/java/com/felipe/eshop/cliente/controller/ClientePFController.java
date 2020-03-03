package com.felipe.eshop.cliente.controller;

import com.felipe.eshop.cliente.entity.ClientePF;
import com.felipe.eshop.cliente.entity.Endereco;
import com.felipe.eshop.cliente.entity.Telefone;
import com.felipe.eshop.cliente.entity.dto.ClienteDadosPessoaisDTO;
import com.felipe.eshop.cliente.entity.dto.NovoClienteDTO;
import com.felipe.eshop.cliente.repository.ClientePFRepository;
import com.felipe.eshop.cliente.service.ClientePFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Endereco> listaEnderecosCliente(@PathVariable String id){
        ClientePF clientePF = clientePFService.findById(id);
        return clientePF.getEnderecos();
    }

    @GetMapping(value = "/{id}/telefones")
    public List<Telefone> listaTelefonesCliente(@PathVariable String id){
        ClientePF clientePF = clientePFService.findById(id);
        return clientePF.getTelefones();
    }

    @GetMapping(value = "/{id}/dadospessoais")
    public ClienteDadosPessoaisDTO dadosPessoais(@PathVariable String id){
        ClientePF clientePF = clientePFService.findById(id);
        return new ClienteDadosPessoaisDTO(clientePF);
    }

    @PostMapping
    public ClientePF novoCliente(@RequestBody NovoClienteDTO novoCliente){
        return clientePFService.save(novoCliente);
    }

    @GetMapping(value = "/text")
    public String listaClientesPFText(){
        return clientePFService.converterParaString();
    }

}
