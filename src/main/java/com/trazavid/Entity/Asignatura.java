package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salon;

    @Column(length= 40 )
    private String objetivo;

    @Column(length= 40 )
    private String nombre;

    @Column(length= 40 )
    private String unidades;

    @Column(length= 15)
    private Integer carga_horaria;

}
