package com.trazavid.Entity;

import javax.persistence.*;
@Entity
@Table(name ="Salon")
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_salon;

    @Column(name="capacidad")
    private Integer capacidad;

    @Column(length= 40 )
    private String descripcion;

    @Column(length= 40 )
    private String nombre;


    }
