package com.felipe.eshop.categoria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProdutoController.class)
public class ProdutoControllerTest {

    public Produto criaProduto(){
        Produto produto = new Produto();
        produto.setId("1234");
        produto.setNome("Produto Teste");
        produto.setPreco(250.5);
        return produto;
    }

    public Produto criaProduto2(){
        Produto produto = new Produto();
        produto.setId("1234");
        produto.setNome("opa");
        produto.setPreco(250.5);
        return produto;
    }

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ProdutoService produtoService;

    @Test
    void listarProdutosTest() throws Exception {

        Produto produto = criaProduto();

        when(produtoService.listAll()).thenReturn(Arrays.asList(produto));

        mockMvc
                .perform(get("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1234"))
                .andExpect(jsonPath("$[0].nome").value("Produto Teste"))
                .andExpect(jsonPath("$[0].preco").value(250.5));
    }

    @Test
    void listarProdutoPorIdTest() throws Exception{
        Produto produto = criaProduto();

        when(produtoService.findById(produto.getId())).thenReturn(produto);

        mockMvc
                .perform(get("/produtos/{id}", "1234")
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1234"))
                .andExpect(jsonPath("$.nome").value("Produto Teste"))
                .andExpect(jsonPath("$.preco").value(250.5));

    }

    @Test
    void criarProdutoTest() throws Exception {

        Produto produto = criaProduto();

        when(produtoService.save(produto)).thenReturn(produto);

        mockMvc
                .perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.preco").value(250.5));

        ArgumentCaptor<Produto> produtoArgumentCaptor = ArgumentCaptor.forClass(Produto.class);
        verify(produtoService, times(1)).save(produtoArgumentCaptor.capture());
        assertThat(produtoArgumentCaptor.getValue().getId()).isEqualTo("1234");
        assertThat(produtoArgumentCaptor.getValue().getNome()).isEqualTo("Produto Teste");
        assertThat(produtoArgumentCaptor.getValue().getPreco()).isEqualTo(250.5);


    }

    @Test
    void atualizarProdutoTeste() throws Exception{

        Produto produto = criaProduto();
        Produto produto2 = criaProduto2();

        produto.setNome("opa");

        when(produtoService.save(produto2)).thenReturn(produto);

        mockMvc
                .perform(put("/produtos/" + produto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto2)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value(produto2.getNome()));
    }

    @Test
    void buscarProdutoPorIdTeste() throws  Exception{

        Produto produto = criaProduto();

        when(produtoService.findById(produto.getId())).thenReturn(produto);

        mockMvc
                .perform(get("/produtos/" + produto.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value(produto.getNome()));
    }

    @Test
    void deletarProdutoPorIdTeste() throws  Exception {

        Produto produto = criaProduto();

        mockMvc
                .perform(delete("/produtos/" + produto.getId()))
                .andExpect(status().isAccepted());
    }
}
