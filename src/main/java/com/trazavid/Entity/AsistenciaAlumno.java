package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="AsistenciaAlumno")
public class AsistenciaAlumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistenciaAlumno;

    @Column(name = "fecha")
    @Basic
    private java.sql.Date fecha;

    @Column(name="id_curso")
    private Long id_curso;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "asistencia_alumnos",
            joinColumns = @JoinColumn(name = "id_asistenciaAlumno"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumnos = new HashSet<>();

    public AsistenciaAlumno(Date fecha, Long id_curso, Set<Alumno> alumnos) {
        this.fecha = fecha;
        this.id_curso = id_curso;
        this.alumnos = alumnos;
    }

    public AsistenciaAlumno() {
    }

    public Long getId_asistenciaAlumno() {
        return id_asistenciaAlumno;
    }

    public void setId_asistenciaAlumno(Long id_asistenciaAlumno) {
        this.id_asistenciaAlumno = id_asistenciaAlumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
