package com.felipe.eshop.cliente.service;

import com.felipe.eshop.cliente.entity.Cidade;
import com.felipe.eshop.cliente.entity.ClientePF;
import com.felipe.eshop.cliente.entity.Endereco;
import com.felipe.eshop.cliente.entity.Telefone;
import com.felipe.eshop.cliente.entity.dto.NovoClienteDTO;
import com.felipe.eshop.cliente.repository.ClientePFRepository;
import com.felipe.eshop.cliente.repository.EnderecoRepository;
import com.felipe.eshop.cliente.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClientePFService {

    @Autowired
    ClientePFRepository repository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    CidadeService cidadeService;
    @Autowired
    TelefoneRepository telefoneRepository;

    public ClientePF findById(String id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não encontrado!"));
    }

    public ClientePF save(NovoClienteDTO novoCliente) {

        Cidade cidade = cidadeService.findByNome(novoCliente.getCidade());

        Endereco endereco = new Endereco(
                novoCliente.getLogradouro(),
                novoCliente.getNumero(),
                novoCliente.getComplemento(),
                novoCliente.getBairro(),
                novoCliente.getCep(),
                cidade);

        enderecoRepository.save(endereco);

        Telefone telefone = new Telefone(novoCliente.getTelefone());
        telefoneRepository.save(telefone);

        ClientePF cliente = new ClientePF(
                novoCliente.getNome(),
                novoCliente.getEmail(),
                novoCliente.getCpf(),
                Arrays.asList(endereco),
                Arrays.asList(telefone));

        return repository.save(cliente);

    }
}
