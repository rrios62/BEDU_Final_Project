package org.bedu.java.backend.Postwork.controllers;
import org.bedu.java.backend.Postwork.model.Usuario;
import org.bedu.java.backend.Postwork.services.UsuarioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/usuario")
    @RequiredArgsConstructor
    public class UsuarioController {
        private final UsuarioService usuarioService;

        @GetMapping("/{usuarioId}")//Obtener registro específico
        public ResponseEntity<Usuario> getUsuario(@PathVariable Long usuarioId) {

            Optional<Usuario> usuarioDb = usuarioService.getUsuario(usuarioId);

            if (usuarioDb.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe el usuario.");
            }
            return ResponseEntity.ok(usuarioDb.get());
        }

        @GetMapping ()//Obtener todos los registros
        public ResponseEntity<List<Usuario>> getUsuarios() {
            return ResponseEntity.ok(usuarioService.getUsuarios());
        }

        @PostMapping //Crear nuevo registro
        public ResponseEntity<Void> saveUsuario(@RequestBody Usuario usuario) {
            Usuario usuarioNuevo = usuarioService.saveUsuario(usuario);
            return ResponseEntity.created(URI.create(String.valueOf(usuarioNuevo.getId()))).build();
        }

        @PutMapping("/{usuarioId}")//Actualizar registro
        public ResponseEntity<Void> updateUsuario(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {

            usuarioService.updateUsuario(usuario);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        @DeleteMapping("/{usuarioId}")//borrar registro
        public ResponseEntity<Void> deleteUsuario(@PathVariable Long usuarioId) {
            usuarioService.deleteUsuario(usuarioId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
      @PostMapping("/login")//Valida usuario
      public ResponseEntity<Void> loginUsuario(@RequestBody Usuario usuario) {
          Optional<Usuario> usuarioDb = usuarioService.getUsuarioByNombre(usuario.getUsuario());

          if (usuarioDb.isPresent() && usuarioDb.get().getPassw().equals(usuario.getPassw())) {
              return ResponseEntity.ok()
                     // .header("Location", "/cliente.html")
                      .build();
          } else {
              return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
          }
      }
    }
