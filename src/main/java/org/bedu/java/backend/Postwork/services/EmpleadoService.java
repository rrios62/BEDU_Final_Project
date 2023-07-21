package org.bedu.java.backend.Postwork.services;

import lombok.RequiredArgsConstructor;
import org.bedu.java.backend.Postwork.controllers.mappers.EmpleadoMapper;
import org.bedu.java.backend.Postwork.model.Empleado;
import org.bedu.java.backend.Postwork.persistence.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bedu.java.backend.Postwork.DTO.EmpleadoDTO;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final IEmpleadoRepository repository;
    private final EmpleadoMapper mapper;

    public Empleado saveEmpleado(Empleado empleado) {
        return mapper.empleadoEntityToEmpleadoModel(
                repository.save(mapper.empleadoModelToEmpleadoEntity(empleado))
        );
    }

    public List<Empleado> getEmpleados(){
        return repository.findAll().stream().map(empleado ->
                mapper.empleadoEntityToEmpleadoModel(empleado)).collect(Collectors.toList());
    }


    public Optional<Empleado> getEmpleado(long id) {
        return repository.findById(id)
                .map(empleado -> Optional.of(mapper.empleadoEntityToEmpleadoModel(empleado)))
                .orElse(Optional.empty());
    }

    public void deleteEmpleado(long idEmpleado){
        repository.deleteById(idEmpleado);
    }

    public Empleado updateEmpleado(Empleado empleado){
        return mapper.empleadoEntityToEmpleadoModel(
                repository.save(mapper.empleadoModelToEmpleadoEntity(empleado))
        );
    }

    public List<EmpleadoDTO> obtenerTodosLosEmpleadosDto() {
        return repository.findAll().stream()
                .map(empleado -> new EmpleadoDTO(empleado.getId(), empleado.getNombreEmpleado()))
                .collect(Collectors.toList());
    }



}