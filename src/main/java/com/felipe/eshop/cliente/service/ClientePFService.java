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

import java.util.ArrayList;
import java.util.Arrays;
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

    public String converterParaString() {

        List<ClientePF> clientes = repository.findAll();

        List<String> clientesConverter = new ArrayList<>();

        for (ClientePF value : clientes) {

            String clienteStr = "";

            clienteStr = clienteStr.concat(value.getNome() + "|");
            clienteStr = clienteStr.concat(value.getEmail() + "|");
            clienteStr = clienteStr.concat(value.getCpf() + "|");

            for (int c = 0; c < value.getEnderecos().size(); c++){
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getLogradouro() + "|");
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getNumero() + "|");
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getComplemento() + "|");
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getBairro() + "|");
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getCep() + "|");
                clienteStr = clienteStr.concat(value.getEnderecos().get(c).getCidade().getNome() + "|");
            }

            clientesConverter.add(clienteStr);
        }

        String clientesConverterStr = "";

        for(int c = 0; c < clientesConverter.size(); c++){
            clientesConverterStr = clientesConverterStr.concat(clientesConverter.get(c) + "\n");
        }

        return clientesConverterStr;
    }
}
