package org.bedu.java.backend.Postwork.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.Postwork.controllers.mappers.PedidoMapper;
import org.bedu.java.backend.Postwork.model.Pedido;
import org.bedu.java.backend.Postwork.persistence.IPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final IPedidoRepository repository;
    private final PedidoMapper mapper;

    public Pedido savePedido(Pedido pedido) {
        return mapper.pedidoEntityToPedidoModel(
                repository.save(mapper.pedidoModelToPedidoEntity(pedido))
        );
    }

    public List<Pedido> getPedidos() {
        return repository.findAll().stream().map(pedido ->
                mapper.pedidoEntityToPedidoModel(pedido)).collect(Collectors.toList());

    }

    public Optional<Pedido> getPedido(long idPedido) {
        return repository.findById(idPedido)
                .map(pedido -> Optional.of(mapper.pedidoEntityToPedidoModel(pedido)))
                .orElse(Optional.empty());
    }

    public void deletePedido(long idPedido) {
        repository.deleteById(idPedido);
    }

    public Pedido updatePedido(Pedido pedido) {
        return mapper.pedidoEntityToPedidoModel(
                repository.save(mapper.pedidoModelToPedidoEntity(pedido))
        );
    }
}
