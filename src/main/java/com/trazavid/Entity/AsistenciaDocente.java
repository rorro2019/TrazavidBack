package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="AsistenciaDocente")
public class AsistenciaDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistenciaDocente;

    @Column(name = "asistio")
    @Basic
    private java.sql.Date asistio;
}