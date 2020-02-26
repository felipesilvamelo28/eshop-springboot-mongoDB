package com.felipe.eshop.cliente.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class ClientePF {
    @Id
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    public ClientePF(String nome, String email, String cpf, List<Endereco> enderecos, List<Telefone> telefones) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    public ClientePF() {
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

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientePF)) return false;
        ClientePF clientePF = (ClientePF) o;
        return Objects.equals(getId(), clientePF.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
