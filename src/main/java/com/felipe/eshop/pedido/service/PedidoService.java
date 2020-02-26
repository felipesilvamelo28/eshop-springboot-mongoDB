package com.felipe.eshop.pedido.service;

import com.felipe.eshop.pedido.entity.Pedido;
import com.felipe.eshop.pedido.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(String id){
        return pedidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Pedido não encontrado!"));
    }

}
