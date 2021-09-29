package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Burbuja")
public class Burbuja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_burbuja;

    @Column(length= 50)
    private String nombre;

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

    @Column(name="id_institucion")
    private Long id_institucion;

    //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "alumno_alumnoss",
            joinColumns = @JoinColumn(name = "id_burbuja"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> Alumno = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "burbuja_docentes",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docente = new HashSet<>();

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

    public Set<com.trazavid.Entity.Alumno> getAlumno() {
        return Alumno;
    }

    public void setAlumno(Set<com.trazavid.Entity.Alumno> alumno) {
        Alumno = alumno;
    }

    public Set<com.trazavid.Entity.Docente> getDocente() {
        return Docente;
    }

    public void setDocente(Set<com.trazavid.Entity.Docente> docente) {
        Docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Burbuja(String nombre, Date fechabaja, Long id_institucion, Set<com.trazavid.Entity.Alumno> alumno, Set<com.trazavid.Entity.Docente> docente) {
        this.nombre = nombre;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
        Alumno = alumno;
        Docente = docente;
    }

}
