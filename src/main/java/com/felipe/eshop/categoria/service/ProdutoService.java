package com.felipe.eshop.categoria.service;

import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> listAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(String id){
        return produtoRepository.findById(id).orElseThrow(()-> new RuntimeException("Produto não encontrada!"));
    }

    public Produto save(Produto produto){
       // produto.setId(null);
        return produtoRepository.save(produto);
    }

    public void delete(String id){
        produtoRepository.deleteById(id);
    }

}
