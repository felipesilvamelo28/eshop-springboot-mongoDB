package com.felipe.eshop.categoria.controller;

import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.repository.ProdutoRepository;
import com.felipe.eshop.categoria.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value ="converter-txt", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getConteudo () {
        List<Produto> produtos = produtoService.listAll();

        List<String> produtosConverter = new ArrayList<>();

        for (Produto value : produtos) {
            String produtosStr = "";

            produtosStr = produtosStr.concat(value.getNome());
            produtosStr = produtosStr.concat(value.getPreco().toString());

            produtosConverter.add(produtosStr);
        }


        return produtosConverter.get(0);



    }

    @GetMapping()
    private List<Produto> listarProdutos(){
        return produtoService.listAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    private Produto listarProduto(@PathVariable String id){
        return produtoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Produto criarProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @PutMapping(value = "/{id}")
    private Produto atualizarProduto(@RequestBody Produto produto, @PathVariable String id){
        //produto.setId(id);
        return produtoService.save(produto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    private void deletarProduto(@PathVariable String id){
        produtoService.delete(id);
    }



}
