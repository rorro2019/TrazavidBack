package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    @Column(length= 50)
    private String nombreTutor;

    @Column(length= 15)
    private Long contactoTutor;

}
