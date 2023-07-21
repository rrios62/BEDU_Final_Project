package org.bedu.java.backend.Postwork.controllers;

import org.bedu.java.backend.Postwork.DTO.EmpleadoDTO;
import org.bedu.java.backend.Postwork.model.Empleado;
import org.bedu.java.backend.Postwork.services.EmpleadoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @GetMapping("/{empleadoId}")//Obtener registro específico
    public ResponseEntity<Empleado> getEmpleado(@PathVariable Long empleadoId) {

        Optional<Empleado> empleadoDb = empleadoService.getEmpleado(empleadoId);

        if (empleadoDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el empleado.");
        }
        return ResponseEntity.ok(empleadoDb.get());
    }

    @GetMapping//Obtener todos los registros
    public ResponseEntity<List<Empleado>> getEmpleados() {
        return ResponseEntity.ok(empleadoService.getEmpleados());
    }

    @PostMapping//Crear nuevo registro
    public ResponseEntity<Void> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado empleadoNuevo = empleadoService.saveEmpleado(empleado);
        return ResponseEntity.created(URI.create(String.valueOf(empleadoNuevo.getId()))).build();
    }

    @PutMapping("/{empleadoId}")//Actualizar registro
    public ResponseEntity<Void> updateEmpleado(@PathVariable Long empleadoId, @RequestBody Empleado empleado) {

        empleadoService.updateEmpleado(empleado);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{empleadoId}")//borrar registro
    public ResponseEntity<Void> deleteEmpleado(@PathVariable Long empleadoId) {
        empleadoService.deleteEmpleado(empleadoId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/empleadosdto")
    public ResponseEntity<List<EmpleadoDTO>> obtenerTodosLosEmpleadosDto() {
        return ResponseEntity.ok(empleadoService.obtenerTodosLosEmpleadosDto());
    }
}
