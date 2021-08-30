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
    private String subdivision;

    @Column(length= 40 )
    private String turno;

    @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public Curso(Integer division, String subdivision, String turno, Institucion institucion) {
        this.division = division;
        this.subdivision = subdivision;
        this.turno = turno;
        this.institucion = institucion;
    }

    public Curso() {
    }

    public Curso(Integer division, String subdivision, String turno) {
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
}
