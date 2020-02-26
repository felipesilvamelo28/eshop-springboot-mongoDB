package com.felipe.eshop.cliente.entity.dto;

import com.felipe.eshop.cliente.entity.ClientePF;

public class ClienteDadosPessoaisDTO {

    private String nome;
    private String email;
    private  String cpf;

    public ClienteDadosPessoaisDTO(ClientePF clientePF) {
        this.nome = clientePF.getNome();
        this.email = clientePF.getEmail();
        this.cpf = clientePF.getCpf();
    }

    public ClienteDadosPessoaisDTO() {
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
