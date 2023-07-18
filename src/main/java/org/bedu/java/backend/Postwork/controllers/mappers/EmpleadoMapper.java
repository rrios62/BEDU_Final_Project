package org.bedu.java.backend.Postwork.controllers.mappers;

import org.bedu.java.backend.Postwork.persistence.entities.Empleado;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface EmpleadoMapper {
    Empleado empleadoModelToEmpleadoEntity(org.bedu.java.backend.Postwork.model.Empleado empleadoModel);
    org.bedu.java.backend.Postwork.model.Empleado empleadoEntityToEmpleadoModel(Empleado empleado);

}
