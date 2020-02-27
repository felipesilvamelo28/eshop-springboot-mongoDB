package com.felipe.eshop.categoria.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.eshop.categoria.entity.Categoria;
import com.felipe.eshop.categoria.entity.Produto;
import com.felipe.eshop.categoria.service.CategoriaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoriaController.class)
public class CategoriaControllerTest {

    @MockBean
    private CategoriaService categoriaService;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void listaCategoriaByIdTest() throws Exception {

        Produto produto1 = new Produto("Computador", 2000.0);
        produto1.setId("1");
        Produto produto2 = new Produto("Impressora", 1500.0);
        produto2.setId("2");

        List<Produto> produtos = new ArrayList<>(Arrays.asList(produto1, produto2));

        String nome = "Informática";
        String id = "12345";

        Categoria categoria = new Categoria(nome, produtos);
        categoria.setId(id);


        when(categoriaService.findById(id)).thenReturn(categoria);

        mockMvc
                .perform(get("/categorias/" + id)
                        .content(objectMapper.writeValueAsString(categoria))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nome").value(nome))
                .andExpect(jsonPath("$.produtos").isNotEmpty())
                .andExpect(jsonPath("$.produtos").isArray())
                .andExpect(jsonPath("$.produtos[0].id").value("1"))
                .andExpect(jsonPath("$.produtos[1].id").value("2"));
    }

}
