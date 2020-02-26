package com.felipe.eshop.pedido.entity;

import com.felipe.eshop.cliente.entity.ClientePF;
import com.felipe.eshop.cliente.entity.Endereco;
import com.felipe.eshop.pedido.dto.ClientePFDTOPedido;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Pedido {

    @Id
    private String id;
    private ClientePFDTOPedido clientePF;
    private List<ItemPedido> itens = new ArrayList<>();
    private Endereco endereco;

    public Pedido(ClientePFDTOPedido clientePF, List<ItemPedido> itens, Endereco endereco) {
        this.clientePF = clientePF;
        this.itens = itens;
        this.endereco = endereco;
    }

    public Pedido() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientePFDTOPedido getClientePF() {
        return clientePF;
    }

    public void setClientePF(ClientePFDTOPedido clientePF) {
        this.clientePF = clientePF;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
