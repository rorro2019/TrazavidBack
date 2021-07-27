package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="AsistenciaAlumno")
public class AsistenciaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistenciaAlumno;

    @Column(name = "asistio")
    @Basic
    private java.sql.Date asistio;
}
