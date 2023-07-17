package org.bedu.java.backend.Postwork.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "passw", nullable = false)
    private String passw;
    @Column(name = "rol", nullable = false)
    private String rol;
}
