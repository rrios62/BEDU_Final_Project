package org.bedu.java.backend.Postwork.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.Postwork.controllers.mappers.UsuarioMapper;
import org.bedu.java.backend.Postwork.persistence.IUsuarioRepository;
import org.bedu.java.backend.Postwork.model.Usuario;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final IUsuarioRepository repository;
    private final UsuarioMapper mapper;

    public Usuario saveUsuario(Usuario usuario) {
        return mapper.usuarioEntityToUsuarioModel(
                repository.save(mapper.usuarioModelToUsuarioEntity(usuario))
        );
    }

    public List<Usuario> getUsuarios() {
        return repository.findAll().stream().map(usuario ->
                mapper.usuarioEntityToUsuarioModel(usuario)).collect(Collectors.toList());
    }

    public Optional<Usuario> getUsuario(long usuarioId) {
        return repository.findById(usuarioId)
                .map(usuario -> Optional.of(mapper.usuarioEntityToUsuarioModel(usuario)))
                .orElse(Optional.empty());
    }

    public void deleteUsuario(long usuarioId) {
        repository.deleteById(usuarioId);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return mapper.usuarioEntityToUsuarioModel(
                repository.save(mapper.usuarioModelToUsuarioEntity(usuario))
        );
    }

    public Optional<Usuario> getUsuarioByNombre(String nombreUsuario) {
        return repository.findByUsuario(nombreUsuario)
                .map(usuario -> Optional.of(mapper.usuarioEntityToUsuarioModel(usuario)))
                .orElse(Optional.empty());
    }

}

