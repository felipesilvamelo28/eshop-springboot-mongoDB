package com.felipe.eshop.pedido.controller;

import com.felipe.eshop.pedido.entity.Pedido;
import com.felipe.eshop.pedido.repository.PedidoRepository;
import com.felipe.eshop.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarPedidos(){
        return pedidoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pedido listarPedidoById(@PathVariable String id){
        return pedidoService.findById(id);
    }

}
