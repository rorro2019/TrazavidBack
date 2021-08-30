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

    @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    public Salon(Integer capacidad, String descripcion, String nombre) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre = nombre;
    }

    public Salon() {
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

    public Salon(Integer capacidad, String descripcion, String nombre, Institucion institucion) {
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.institucion = institucion;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
}
