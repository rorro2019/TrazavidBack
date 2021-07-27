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

}
