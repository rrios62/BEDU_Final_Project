package org.bedu.java.backend.Postwork.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PEDIDOS")
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente", nullable = false)
    private String cliente;

    @Column(name = "equipo")
    private String equipo;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "potencia")
    private int potencia;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "rpm")
    private int rpm;

    @Column(name = "frecuencia")
    private int frecuencia;

    @Column(name = "amperes")
    private int amperes;

    @Column(name = "armazon")
    private String armazon;

    @Column(name = "marca")
    private String marca;

    @Column(name = "serie")
    private String serie;

    @Column(name = "desensamble")
    private String desensamble;

    @Column(name = "ensamble")
    private String ensamble;

    @Column(name = "embobinado")
    private String embobinado;

    @Column(name = "pruebas")
    private String pruebas;

    @Column(name = "notas")
    private String notas;

    @Column(name = "estatus")
    private String estatus;

    @Column(name = "factura")
    private String factura;









}
