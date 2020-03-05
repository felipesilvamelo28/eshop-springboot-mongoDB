package com.felipe.eshop.cliente.service;

import com.felipe.eshop.categoria.entity.Produto;
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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    @Autowired
    ArquivoService arquivoService;

    public ClientePF findById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
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
                Collections.singletonList(endereco),
                Collections.singletonList(telefone));

        return repository.save(cliente);

    }

    public String converterParaString() throws IOException {

        List<ClientePF> clientes = repository.findAll();
        StringBuilder builder = new StringBuilder();

        for (ClientePF value : clientes) {
            for (Endereco endereco: value.getEnderecos()) {
                StringBuilder linha = new StringBuilder();
                linha.append(value.getNome()).append("|");
                linha.append(value.getEmail()).append("|");
                linha.append(value.getCpf()).append("|");

                linha.append(endereco.getLogradouro()).append("|");
                linha.append(endereco.getNumero()).append("|");
                linha.append(endereco.getComplemento()).append("|");
                linha.append(endereco.getBairro()).append("|");
                linha.append(endereco.getCep()).append("|");
                linha.append(endereco.getCidade().getNome());
                builder.append(linha).append("\n");
            }
        }
        return builder.toString();
    }
}
