package org.bedu.java.backend.Postwork.persistence;

import org.bedu.java.backend.Postwork.persistence.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado, Long> {

}
