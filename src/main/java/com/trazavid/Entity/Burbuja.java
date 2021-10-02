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
    private Set<Alumno> Alumnos = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "burbuja_docentes",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docentes = new HashSet<>();


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_curso")
    private Curso curso;

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

    public Burbuja(String nombre, Date fechabaja, Long id_institucion, Set<Alumno> alumnos, Set<Docente> docentes) {
        this.nombre = nombre;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
        Alumnos = alumnos;
        Docentes = docentes;
    }

    public Set<Alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        Alumnos = alumnos;
    }

    public Set<Docente> getDocentes() {
        return Docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        Docentes = docentes;
    }

    public Burbuja(String nombre, Date fechabaja, Long id_institucion, Set<Alumno> alumnos, Set<Docente> docentes, Curso curso) {
        this.nombre = nombre;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
        Alumnos = alumnos;
        Docentes = docentes;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
