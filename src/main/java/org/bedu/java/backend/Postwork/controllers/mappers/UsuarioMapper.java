package org.bedu.java.backend.Postwork.controllers.mappers;

import org.bedu.java.backend.Postwork.persistence.entities.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    Usuario usuarioModelToUsuarioEntity(org.bedu.java.backend.Postwork.model.Usuario usuarioModel);
    org.bedu.java.backend.Postwork.model.Usuario usuarioEntityToUsuarioModel(Usuario usuario);
}
