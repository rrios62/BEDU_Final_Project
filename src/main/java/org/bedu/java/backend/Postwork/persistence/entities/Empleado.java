package org.bedu.java.backend.Postwork.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLEADOS")
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_empleado", nullable = false)
    private String nombreEmpleado;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "actividad")
    private String actividad;

    @Column(name = "numeroEmpleado")
    private int numeroEmpleado;
}
