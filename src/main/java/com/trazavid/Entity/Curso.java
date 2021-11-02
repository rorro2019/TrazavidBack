package com.trazavid.Entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;

    @Column(name="division")
    private Integer division;

    @Column(name="subdivision")
    private String subdivision;

    @Column(length= 40 )
    private String turno;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "FK_salon")
    private Salon Salon;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "curso_docentes",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docente = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "curso_alumnos",
            joinColumns = @JoinColumn(name = "id_curso"),
            inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> alumno = new HashSet<>();


    /** @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Set<Asignatura> asignatura = new HashSet<>();**/

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

    @Column(name="id_institucion")
    private Long id_institucion;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "institucion_asistenciaAlumno",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_asistenciaAlumno"))
    private Set<AsistenciaAlumno> AsistenciaAlumno = new HashSet<>();

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Curso() {
    }

    public Curso(Integer division, String subdivision, String turno, Date fechabaja) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;

        this.fechabaja = fechabaja;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getDivision() {
        return division;
    }

    public void setDivision(Integer division) {
        this.division = division;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public com.trazavid.Entity.Salon getSalon() {
        return Salon;
    }

    public void setSalon(com.trazavid.Entity.Salon salon) {
        Salon = salon;
    }


    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Curso(Integer division, String subdivision, String turno, com.trazavid.Entity.Salon salon, Date fechabaja, Long id_institucion) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
        Salon = salon;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
    }

    public Curso(Integer division, String subdivision, String turno, com.trazavid.Entity.Salon salon, Set<com.trazavid.Entity.Docente> docente, Date fechabaja, Long id_institucion) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
        Salon = salon;
        Docente = docente;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
    }

    public Set<com.trazavid.Entity.Docente> getDocente() {
        return Docente;
    }

    public void setDocente(Set<com.trazavid.Entity.Docente> docente) {
        Docente = docente;
    }

    public Curso(Integer division, String subdivision, String turno, com.trazavid.Entity.Salon salon, Set<com.trazavid.Entity.Docente> docente, Set<Alumno> alumno, Date fechabaja, Long id_institucion) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
        Salon = salon;
        Docente = docente;
        this.alumno = alumno;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
    }

    public Set<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(Set<Alumno> alumno) {
        this.alumno = alumno;
    }

    public Set<com.trazavid.Entity.AsistenciaAlumno> getAsistenciaAlumno() {
        return AsistenciaAlumno;
    }

    public void setAsistenciaAlumno(Set<com.trazavid.Entity.AsistenciaAlumno> asistenciaAlumno) {
        AsistenciaAlumno = asistenciaAlumno;
    }

    public Curso(Integer division, String subdivision, String turno, com.trazavid.Entity.Salon salon, Set<com.trazavid.Entity.Docente> docente, Set<Alumno> alumno, Date fechabaja, Long id_institucion, Set<com.trazavid.Entity.AsistenciaAlumno> asistenciaAlumno) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
        Salon = salon;
        Docente = docente;
        this.alumno = alumno;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
        AsistenciaAlumno = asistenciaAlumno;
    }
}
