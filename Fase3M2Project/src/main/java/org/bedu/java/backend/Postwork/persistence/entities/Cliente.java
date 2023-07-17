package org.bedu.java.backend.Postwork.persistence.entities;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CLIENTES")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contacto", nullable = false)
    private String contacto;

    @Column(name = "correoContacto")
    private String correoContacto;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

}