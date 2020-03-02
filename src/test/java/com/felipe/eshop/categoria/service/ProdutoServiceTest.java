package com.felipe.eshop.categoria.service;

import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.repository.ProdutoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceTest {

    @Mock
    ProdutoRepository produtoRepository;
    @InjectMocks
    ProdutoService produtoService;

    public Produto criaProduto(){
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(250.5);
        return produto;
    }

    @Test
    public void criarProdutoTest () {

        Produto produto = criaProduto();

        when(produtoRepository.save(produto)).thenReturn(new Produto("Produto Teste", 250.5));

        Produto produtoCriado = produtoService.save(produto);

        assertThat(produtoCriado.getNome()).isEqualTo("Produto Teste");
        assertThat(produtoCriado.getPreco()).isEqualTo(250.5);

    }

    @Test
    public void deletarProdutoTest () {

        Produto produto = criaProduto();
        produto.setId("1");
        produtoService.delete(produto.getId());

        verify(produtoRepository, times(1)).deleteById(produto.getId());

    }

    @Test
    public void findByIdTest(){
        Produto produto = criaProduto();
        produto.setId("1");

        Produto produto2 = criaProduto();
        produto.setId("2");

        when(produtoRepository.findById("1")).thenReturn(java.util.Optional.of(produto));

        Produto produtoNovo = produtoService.findById("1");

        assertThat(produtoService.findById("1")).isNotNull();
        assertThat(produtoNovo).isSameAs(produtoService.findById("1"));
        assertThat(produtoNovo.getNome()).isEqualTo(produto.getNome());


    }

    @Test
    public void findAllById(){
        Produto produto1 = criaProduto();
        Produto produto2 = criaProduto();
        Produto produto3 = criaProduto();

        List<Produto> produtosCriados = Arrays.asList(produto1, produto2, produto3);

        when(produtoRepository.findAll()).thenReturn(produtosCriados);

        List<Produto> produtos = produtoService.listAll();

        assertThat(produtos.size()).isEqualTo(3);
        assertThat(produtos).isEqualTo(produtosCriados);

    }



}
