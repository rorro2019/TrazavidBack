package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="CasoPositivo")
public class CasoPositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casoPositivo;

    @Column(name = "fechaDeteccion")
    @Basic
    private java.sql.Date fechaDeteccion;

    @Column(name = "fechaAlta")
    @Basic
    private java.sql.Date fechaAlta;

}
