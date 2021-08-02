package com.trazavid.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name ="Alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    @Column(length= 50)
    private String nombre;

    @Column(length= 40)
    private String apellido;

    @Column(name = "fechaNacimiento")
    @Basic
    private java.sql.Date fechaNacimiento;

    @Column(name="dni")
    private Integer dni;

    @Column(length= 40 )
    private String direccion;

    @Column(length= 40 )
    private String ciudad;

    @Column(length= 40 )
    private String provincia;

    @Column(length= 15)
    private Integer telefono;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @Column(length= 50)
    private String nombreTutor;

    @Column(length= 15)
    private Long contactoTutor;

}
