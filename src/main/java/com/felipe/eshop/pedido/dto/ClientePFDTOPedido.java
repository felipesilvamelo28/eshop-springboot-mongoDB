package com.felipe.eshop.pedido.dto;

import com.felipe.eshop.cliente.entity.ClientePF;
import com.felipe.eshop.cliente.entity.Endereco;
import com.felipe.eshop.cliente.entity.Telefone;

import java.util.List;

public class ClientePFDTOPedido {

    private String id;
    private String nome;
    private String email;
    private String cpf;

    public ClientePFDTOPedido(ClientePF cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
    }

    public ClientePFDTOPedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
