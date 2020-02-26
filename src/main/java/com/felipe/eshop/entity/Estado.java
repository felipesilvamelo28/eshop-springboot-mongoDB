package com.felipe.eshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class Estado {
    @Id
    private String id;
    private String nome;

    public Estado(String nome) {
        this.nome = nome;
    }

    public Estado() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;
        Estado estado = (Estado) o;
        return Objects.equals(getId(), estado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
