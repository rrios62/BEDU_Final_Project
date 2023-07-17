package org.bedu.java.backend.Postwork.controllers;

import org.bedu.java.backend.Postwork.model.Pedido;
import org.bedu.java.backend.Postwork.services.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

     @GetMapping("/{pedidoId}") // Obtener pedido específico
    public ResponseEntity<Pedido> getPedido(@PathVariable Long pedidoId) {

        Optional<Pedido> pedidoDb = pedidoService.getPedido(pedidoId);

        if (pedidoDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el pedido.");
        }
        return ResponseEntity.ok(pedidoDb.get());
    }

    @GetMapping() // Obtener todos los pedidos
    public ResponseEntity<List<Pedido>> getPedidos() {
        return ResponseEntity.ok(pedidoService.getPedidos());
    }

    @PostMapping // Crear nuevo pedido
    public ResponseEntity<Void> savePedido(@RequestBody Pedido pedido) {
        Pedido pedidoNuevo = pedidoService.savePedido(pedido);
        return ResponseEntity.created(URI.create(String.valueOf(pedidoNuevo.getId()))).build();
    }

    @PutMapping("/{pedidoId}") // Actualizar pedido
    public ResponseEntity<Void> updatePedido(@PathVariable Long pedidoId, @RequestBody Pedido pedido) {

        pedidoService.updatePedido(pedido);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{pedidoId}") // Borrar pedido
    public ResponseEntity<Void> deletePedido(@PathVariable Long pedidoId) {
        pedidoService.deletePedido(pedidoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
