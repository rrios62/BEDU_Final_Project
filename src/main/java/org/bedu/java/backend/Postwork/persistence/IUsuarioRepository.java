package org.bedu.java.backend.Postwork.persistence;

import org.bedu.java.backend.Postwork.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Column;
import java.util.Optional;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
