package com.trazavid.Entity;


import javax.persistence.*;

@Entity
@Table(name ="Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;

    @Column(name="division")
    private Integer division;

    @Column(name="subdivision")
    private Integer subdivision;

    @Column(length= 40 )
    private String turno;

    public Curso() {
    }

    public Curso(Integer division, Integer subdivision, String turno) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
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

    public Integer getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(Integer subdivision) {
        this.subdivision = subdivision;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
