package com.trazavid.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;

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
    private Long telefono;

    @Column(name = "fechabaja")
    @Basic
    private java.sql.Date fechabaja;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @Column(length= 50)
    private String nombreTutor;

    @Column(length= 15)
    private Long contactoTutor;

   /** @ManyToOne
    @JoinColumn(name = "FK_institucion", nullable = false, updatable = false)
    private Institucion institucion;

    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
**/
    public Alumno(String nombre, String apellido, Date fechaNacimiento, Integer dni, String direccion, String ciudad, String provincia, Long telefono, @NotBlank @Size(max = 50) @Email String email, String nombreTutor, Long contactoTutor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.nombreTutor = nombreTutor;
        this.contactoTutor = contactoTutor;

    }

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public Long getContactoTutor() {
        return contactoTutor;
    }

    public void setContactoTutor(Long contactoTutor) {
        this.contactoTutor = contactoTutor;
    }

    public Alumno() {
    }



    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }
}
