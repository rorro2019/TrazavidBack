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

   /** @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Set<Asignatura> asignatura = new HashSet<>();**/

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

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
}
