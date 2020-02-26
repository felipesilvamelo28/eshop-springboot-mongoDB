package com.felipe.eshop.categoria.controller;

import com.felipe.eshop.categoria.entity.Categoria;
import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    private List<Categoria> listaCategorias(){
        return categoriaService.findAll();
    }

    @GetMapping(value = "/{id}")
    private Categoria listaCategoriaById(@PathVariable String id){
        return categoriaService.findById(id);
    }

    @GetMapping(value = "/{id}/produtos")
    private List<Produto> listaProdutosCategoria(@PathVariable String id){
        Categoria categoria = categoriaService.findById(id);
        return categoria.getProdutos();
    }

}
