package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;


    public Salon() {
    }

    public Salon(Integer capacidad, String descripcion, String nombre, java.sql.Date fechabaja) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.fechabaja = fechabaja;
    }

    public Long getId_salon() {
        return id_salon;
    }

    public void setId_salon(Long id_salon) {
        this.id_salon = id_salon;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public java.sql.Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(java.sql.Date fechabaja) {
        this.fechabaja = fechabaja;
    }
}
