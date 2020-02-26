package com.felipe.eshop.config;

import com.felipe.eshop.categoria.entity.Categoria;
import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.repository.CategoriaRepository;
import com.felipe.eshop.categoria.repository.ProdutoRepository;
import com.felipe.eshop.cliente.entity.*;
import com.felipe.eshop.cliente.repository.*;
import com.felipe.eshop.pedido.dto.ClientePFDTOPedido;
import com.felipe.eshop.pedido.entity.ItemPedido;
import com.felipe.eshop.pedido.entity.Pedido;
import com.felipe.eshop.pedido.repository.ItemPedidoRepository;
import com.felipe.eshop.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Implementation implements CommandLineRunner {

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
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ItemPedidoRepository itemPedidoRepository;


    @Override
    public void run(String... args) throws Exception {

        enderecoRepository.deleteAll();
        cidadeRepository.deleteAll();
        estadoRepository.deleteAll();
        telefoneRepository.deleteAll();
        clientePFRepository.deleteAll();
        categoriaRepository.deleteAll();
        produtoRepository.deleteAll();
        pedidoRepository.deleteAll();
        itemPedidoRepository.deleteAll();

        //IMPLEMENTAÇÃO DO CLIENTE:

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

        Cidade cidade2 = new Cidade("Santos", estado2);
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

        //IMPLEMENTAÇÃO DA CATEGORIA:

        Produto produto1 = new Produto("Computador", 2000.0);
        Produto produto2 = new Produto("Impressora", 1500.0);
        Produto produto3 = new Produto("Iphone 8", 2500.0);
        Produto produto4 = new Produto("Galaxy S9", 2300.0);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4));

        Categoria categoria1 = new Categoria("Informática", Arrays.asList(produto1, produto2));
        Categoria categoria2 = new Categoria("Smartphone", Arrays.asList(produto3, produto4));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

        //IMPLEMENTAÇÃO PEDIDOS:

        ItemPedido itemPedido1 = new ItemPedido(produto1, 2);
        ItemPedido itemPedido2 = new ItemPedido(produto2, 1);
        ItemPedido itemPedido3 = new ItemPedido(produto3, 1);
        ItemPedido itemPedido4 = new ItemPedido(produto4, 2);

        itemPedidoRepository.saveAll(Arrays.asList(itemPedido1,itemPedido2,itemPedido3,itemPedido4));

        Pedido pedido1 = new Pedido(new ClientePFDTOPedido(clientePF1)
                , Arrays.asList(itemPedido1, itemPedido2)
                , clientePF1.getEnderecos().get(0));

        Pedido pedido2 = new Pedido(new ClientePFDTOPedido(clientePF1)
                , Arrays.asList(itemPedido3, itemPedido4)
                , clientePF1.getEnderecos().get(1));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));

    }
}
