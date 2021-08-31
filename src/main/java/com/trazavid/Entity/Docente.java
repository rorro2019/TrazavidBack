package com.trazavid.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name ="Docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_docente;

    @Column(length= 50)
    private String nombre;



    @Column(length= 40 )
    private String apellido;


    @Column(name = "fechaNacimiento")
    @Basic
    private java.sql.Date fechaNacimiento;

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

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

  /**  @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name = "FK_asignatura", nullable = false, updatable = false)
    private Asignatura asignatura;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
**/


    public Docente() {
    }

    public Long getId_docente() {
        return id_docente;
    }

    public void setId_docente(Long id_docente) {
        this.id_docente = id_docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Docente(String nombre, String apellido, Date fechaNacimiento, Integer dni, String direccion, String ciudad, String provincia, Integer telefono, @NotBlank @Size(max = 50) @Email String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
    }



    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public Docente(String nombre, String apellido, Date fechaNacimiento, Date fechabaja, Integer dni, String direccion, String ciudad, String provincia, Integer telefono, @NotBlank @Size(max = 50) @Email String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechabaja = fechabaja;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
    }

}
