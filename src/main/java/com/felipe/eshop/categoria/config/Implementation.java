package com.felipe.eshop.categoria.config;

import com.felipe.eshop.categoria.entity.Categoria;
import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.repository.CategoriaRepository;
import com.felipe.eshop.categoria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Implementation implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {

        categoriaRepository.deleteAll();
        produtoRepository.deleteAll();

        Produto produto1 = new Produto("Computador", 2000.0);
        Produto produto2 = new Produto("Impressora", 1500.0);
        Produto produto3 = new Produto("Iphone 8", 2500.0);
        Produto produto4 = new Produto("Galaxy S9", 2300.0);

        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4));

        Categoria categoria1 = new Categoria("Informática", Arrays.asList(produto1, produto2));
        Categoria categoria2 = new Categoria("Smartphone", Arrays.asList(produto3, produto4));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

    }
}
