package org.bedu.java.backend.Postwork.controllers.mappers;

import org.bedu.java.backend.Postwork.persistence.entities.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    Pedido pedidoModelToPedidoEntity(org.bedu.java.backend.Postwork.model.Pedido pedidoModel);
    org.bedu.java.backend.Postwork.model.Pedido pedidoEntityToPedidoModel(Pedido pedido);
}
