package com.trazavid.Entity;

import javax.persistence.*;

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

    public Asignatura() {
    }

    public Asignatura(String nombre, Integer carga_horaria) {
        this.nombre = nombre;
        this.carga_horaria = carga_horaria;
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
}
