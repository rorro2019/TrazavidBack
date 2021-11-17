package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="AsistenciaDocente")
public class AsistenciaDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asistenciaDocente;

    @Column(name = "fecha")
    @Basic
    private java.sql.Date fecha;

    @Column(name="id_institucion")
    private Long id_institucion;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "asistencia_docentes",
            joinColumns = @JoinColumn(name = "id_asistenciaDocente"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docentes = new HashSet<>();

    public AsistenciaDocente(Date fecha, Long id_institucion, Set<Docente> docentes) {
        this.fecha = fecha;
        this.id_institucion = id_institucion;
        Docentes = docentes;
    }

    public Long getId_asistenciaDocente() {
        return id_asistenciaDocente;
    }

    public void setId_asistenciaDocente(Long id_asistenciaDocente) {
        this.id_asistenciaDocente = id_asistenciaDocente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Set<Docente> getDocentes() {
        return Docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        Docentes = docentes;
    }

    public AsistenciaDocente() {
    }
}