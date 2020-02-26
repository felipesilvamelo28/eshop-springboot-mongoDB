package com.felipe.eshop.config;

import com.felipe.eshop.entity.*;
import com.felipe.eshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    CidadeRepository cidadeRepository;
    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    TelefoneRepository telefoneRepository;
    @Autowired
    ClientePFRepository clientePFRepository;

    @Override
    public void run(String... args) throws Exception {

        enderecoRepository.deleteAll();
        cidadeRepository.deleteAll();
        estadoRepository.deleteAll();
        telefoneRepository.deleteAll();
        clientePFRepository.deleteAll();

        Estado estado1 = new Estado("Paraná");
        estadoRepository.save(estado1);

        Cidade cidade1 = new Cidade("Curitiba", estado1);
        cidadeRepository.save(cidade1);

        Endereco endereco1 = new Endereco("Rua tal"
                , 250
                , "AP 2"
                , "Boa Vista"
                , "82640000"
                , cidade1);

        enderecoRepository.save(endereco1);

        Estado estado2 = new Estado("Sao Paulo");
        estadoRepository.save(estado2);

        Cidade cidade2 = new Cidade("São Caetano", estado2);
        cidadeRepository.save(cidade2);

        Endereco endereco2 = new Endereco("Rua tal e tal"
                , 2500
                , "AP 205"
                , "Boa Vista de SP"
                , "82650000"
                , cidade2);

        enderecoRepository.save(endereco2);

        Telefone telefone1 = new Telefone("998681062");
        Telefone telefone2 = new Telefone("36032574");

        telefoneRepository.saveAll(Arrays.asList(telefone1, telefone2));

        ClientePF clientePF1 = new ClientePF("Felipe Melo"
                , "felipe@email.com"
                , "078273"
                , Arrays.asList(endereco1, endereco2)
                , Arrays.asList(telefone1, telefone2));

        clientePFRepository.save(clientePF1);

    }
}
