package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name ="CasoPositivo")
public class CasoPositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_casoPositivo;

    @Column(name = "fechaDeteccion")
    @Basic
    private java.sql.Date fechaDeteccion;


    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(referencedColumnName  = "id_docente")
    private Docente docente;


    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(referencedColumnName  = "id_alumno")
    private Alumno alumno;

    @Column(name = "fechaAlta")
    @Basic
    private java.sql.Date fechaAlta;

    @Column(name="id_institucion")
    private Long id_institucion;

    public CasoPositivo(Date fechaDeteccion, Docente docente, Alumno alumno, Date fechaAlta) {
        this.fechaDeteccion = fechaDeteccion;
        this.docente = docente;
        this.alumno = alumno;
        this.fechaAlta = fechaAlta;
    }

    public CasoPositivo() {
    }

    public Long getId_casoPositivo() {
        return id_casoPositivo;
    }

    public void setId_casoPositivo(Long id_casoPositivo) {
        this.id_casoPositivo = id_casoPositivo;
    }

    public Date getFechaDeteccion() {
        return fechaDeteccion;
    }

    public void setFechaDeteccion(Date fechaDeteccion) {
        this.fechaDeteccion = fechaDeteccion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public CasoPositivo(Date fechaDeteccion, Docente docente, Alumno alumno, Date fechaAlta, Long id_institucion) {
        this.fechaDeteccion = fechaDeteccion;
        this.docente = docente;
        this.alumno = alumno;
        this.fechaAlta = fechaAlta;
        this.id_institucion = id_institucion;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}
