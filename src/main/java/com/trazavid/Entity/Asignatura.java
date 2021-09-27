package com.trazavid.Entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Asignatura")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Asignatura;

    @Column(length= 40 )
    private String nombre;

    @Column(length= 15)
    private Integer carga_horaria;

  /**  @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    private Set<Docente> Docente = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "FK_curso", nullable = true, updatable = true)
    private Curso curso;**/

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

    @Column(name="id_institucion")
    private Long id_institucion;

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public Asignatura() {
    }

    public Asignatura(String nombre, Integer carga_horaria, Date fechabaja) {
        this.nombre = nombre;
        this.carga_horaria = carga_horaria;
      //  this.institucion = institucion;
       // Docente = docente;
       // this.curso = curso;
        this.fechabaja = fechabaja;
    }

    public Long getId_Asignatura() {
        return id_Asignatura;
    }

    public void setId_Asignatura(Long id_Asignatura) {
        this.id_Asignatura = id_Asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

   /** public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Set<com.trazavid.Entity.Docente> getDocente() {
        return Docente;
    }

    public void setDocente(Set<com.trazavid.Entity.Docente> docente) {
        Docente = docente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
**/
    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Asignatura(String nombre, Integer carga_horaria, Date fechabaja, Long id_institucion) {
        this.nombre = nombre;
        this.carga_horaria = carga_horaria;
        this.fechabaja = fechabaja;
        this.id_institucion = id_institucion;
    }
}
