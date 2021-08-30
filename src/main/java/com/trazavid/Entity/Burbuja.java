package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="Burbuja")
public class Burbuja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_burbuja;

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

    public Burbuja() {
    }

    public Burbuja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Long getId_burbuja() {
        return id_burbuja;
    }

    public void setId_burbuja(Long id_burbuja) {
        this.id_burbuja = id_burbuja;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }
}
