package com.felipe.eshop.pedido.repository;

import com.felipe.eshop.pedido.entity.ItemPedido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends MongoRepository<ItemPedido, String> {
}
