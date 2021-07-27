package com.trazavid.Entity;

import javax.persistence.*;


@Entity
@Table(name ="AsistenciaNoDocente")
public class AsistenciaNoDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistenciaNoDocente;

    @Column(name = "asistio")
    @Basic
    private java.sql.Date asistio;
}