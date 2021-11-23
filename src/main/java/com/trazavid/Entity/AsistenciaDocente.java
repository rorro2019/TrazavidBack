package com.trazavid.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="AsistenciaDocente")
public class AsistenciaDocente {
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id_asistenciaDocente;

    @Id
    private String id_asistenciaDocente;


    @Column(name="id_institucion")
    private Long id_institucion;

    @Column
    private String fecha;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "asistencia_docentes",
            joinColumns = @JoinColumn(name = "id_asistenciaDocente"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docentes = new HashSet<>();

    public AsistenciaDocente() {
    }

    public AsistenciaDocente(String id_asistenciaDocente, Long id_institucion, Set<Docente> docentes) {
        this.id_asistenciaDocente = id_asistenciaDocente;
        this.id_institucion = id_institucion;
        Docentes = docentes;
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

    public String getId_asistenciaDocente() {
        return id_asistenciaDocente;
    }

    public void setId_asistenciaDocente(String id_asistenciaDocente) {
        this.id_asistenciaDocente = id_asistenciaDocente;
    }

    public void setDocentes(Set<Docente> docentes) {
        Docentes = docentes;
    }

    public AsistenciaDocente(String id_asistenciaDocente, Long id_institucion, String fecha, Set<Docente> docentes) {
        this.id_asistenciaDocente = id_asistenciaDocente;
        this.id_institucion = id_institucion;
        this.fecha = fecha;
        Docentes = docentes;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}