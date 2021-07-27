package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="CasoSospechoso")
public class CasoSospechoso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_CasoSospechoso;

    @Column(name = "fechaSospecha")
    @Basic
    private java.sql.Date fechaSospecha;

    @Column(name = "fechaResultado")
    @Basic
    private java.sql.Date fechaResultado;

    @Column(length= 50)
    private String resultado;

}
