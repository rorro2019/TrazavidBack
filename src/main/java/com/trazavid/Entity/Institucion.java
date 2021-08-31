package com.trazavid.Entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="Institucion")
public class Institucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_institucion;

    @Column(length= 50)
    private String nombre;

    @Column(length= 40 )
    private String direccion;

    @Column(length= 40 )
    private String ciudad;

    @Column(length= 40 )
    private String provincia;

    @Column(length= 15)
    private Long telefono;

    @Column(length= 15)
    private Integer director;

    @Column
    private Boolean comun;
    @Column
    private Boolean especial;
    @Column
    private Boolean otra;
    @Column
    private Boolean inicial;
    @Column
    private Boolean primario;
    @Column
    private Boolean secundario;
    @Column
    private Boolean manana;
    @Column
    private Boolean tarde;
    @Column
    private Boolean noche;

    public Institucion(String nombre, String direccion, String ciudad, String provincia, Long telefono, Integer director, Boolean comun, Boolean especial, Boolean otra, Boolean inicial, Boolean primario, Boolean secundario, Boolean manana, Boolean tarde, Boolean noche, Integer aforo, Long idPersonal, Set<com.trazavid.Entity.Salon> salon) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.director = director;
        this.comun = comun;
        this.especial = especial;
        this.otra = otra;
        this.inicial = inicial;
        this.primario = primario;
        this.secundario = secundario;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
        this.aforo = aforo;
        this.idPersonal = idPersonal;
        Salon = salon;
    }

    @Column(length= 3)
    private Integer aforo;

    public Integer getAforo() {
        return aforo;
    }

    public void setAforo(Integer aforo) {
        this.aforo = aforo;
    }

    public void setIdPersonal(Long idPersonal) {
        this.idPersonal = idPersonal;
    }

    @Column
    private Long idPersonal;

    public Long getIdPersonal() {
        return idPersonal;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "institucion_salones",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_salon"))
    private Set<Salon> Salon = new HashSet<>();

 //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
 //  private Set<Salon> Salon = new HashSet<>();

 //   @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(	name = "institucion_cursos",
         joinColumns = @JoinColumn(name = "id_institucion"),
         inverseJoinColumns = @JoinColumn(name = "id_curso"))
    private Set<Curso> Curso = new HashSet<>();

  //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "institucion_alumnoss",
          joinColumns = @JoinColumn(name = "id_institucion"),
          inverseJoinColumns = @JoinColumn(name = "id_alumno"))
    private Set<Alumno> Alumno = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "institucion_docentes",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_docente"))
    private Set<Docente> Docente = new HashSet<>();

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "institucion_asignaturas",
            joinColumns = @JoinColumn(name = "id_institucion"),
            inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
    private Set<Asignatura> Asignatura = new HashSet<>();


    public Institucion() {
    }

    public Institucion(String nombre, String direccion, String ciudad, String provincia, Long telefono, Integer director, Boolean comun, Boolean especial, Boolean otra, Boolean inicial, Boolean primario, Boolean secundario, Boolean manana, Boolean tarde, Boolean noche) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.director = director;
        this.comun = comun;
        this.especial = especial;
        this.otra = otra;
        this.inicial = inicial;
        this.primario = primario;
        this.secundario = secundario;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
    }

    public Set<Salon> getSalon() {
        return Salon;
    }

    public void setSalon(Set<Salon> salon) {
        Salon = salon;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    public Boolean getComun() {
        return comun;
    }

    public void setComun(Boolean comun) {
        this.comun = comun;
    }

    public Boolean getEspecial() {
        return especial;
    }

    public void setEspecial(Boolean especial) {
        this.especial = especial;
    }

    public Boolean getOtra() {
        return otra;
    }

    public void setOtra(Boolean otra) {
        this.otra = otra;
    }

    public Boolean getInicial() {
        return inicial;
    }

    public void setInicial(Boolean inicial) {
        this.inicial = inicial;
    }

    public Boolean getPrimario() {
        return primario;
    }

    public void setPrimario(Boolean primario) {
        this.primario = primario;
    }

    public Boolean getSecundario() {
        return secundario;
    }

    public void setSecundario(Boolean secundario) {
        this.secundario = secundario;
    }

    public Boolean getManana() {
        return manana;
    }

    public void setManana(Boolean manana) {
        this.manana = manana;
    }

    public Boolean getTarde() {
        return tarde;
    }

    public void setTarde(Boolean tarde) {
        this.tarde = tarde;
    }

    public Boolean getNoche() {
        return noche;
    }

    public void setNoche(Boolean noche) {
        this.noche = noche;
    }

    public Institucion(String nombre, String direccion, String ciudad, String provincia, Long telefono, Integer director, Boolean comun, Boolean especial, Boolean otra, Boolean inicial, Boolean primario, Boolean secundario, Boolean manana, Boolean tarde, Boolean noche, Long idPersonal, Set<com.trazavid.Entity.Salon> salon) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.director = director;
        this.comun = comun;
        this.especial = especial;
        this.otra = otra;
        this.inicial = inicial;
        this.primario = primario;
        this.secundario = secundario;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
        this.idPersonal = idPersonal;
        Salon = salon;
    }

    public Institucion(String nombre, String direccion, String ciudad, String provincia, Long telefono, Integer director, Boolean comun, Boolean especial, Boolean otra, Boolean inicial, Boolean primario, Boolean secundario, Boolean manana, Boolean tarde, Boolean noche, Integer aforo, Long idPersonal, Set<com.trazavid.Entity.Salon> salon, Set<com.trazavid.Entity.Curso> curso, Set<com.trazavid.Entity.Alumno> alumno, Set<com.trazavid.Entity.Docente> docente, Set<com.trazavid.Entity.Asignatura> asignatura) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.director = director;
        this.comun = comun;
        this.especial = especial;
        this.otra = otra;
        this.inicial = inicial;
        this.primario = primario;
        this.secundario = secundario;
        this.manana = manana;
        this.tarde = tarde;
        this.noche = noche;
        this.aforo = aforo;
        this.idPersonal = idPersonal;
        Salon = salon;
        Curso = curso;
        Alumno = alumno;
        Docente = docente;
        Asignatura = asignatura;
    }

    public Set<com.trazavid.Entity.Curso> getCurso() {
        return Curso;
    }

    public void setCurso(Set<com.trazavid.Entity.Curso> curso) {
        Curso = curso;
    }

    public Set<com.trazavid.Entity.Alumno> getAlumno() {
        return Alumno;
    }

    public void setAlumno(Set<com.trazavid.Entity.Alumno> alumno) {
        Alumno = alumno;
    }

    public Set<com.trazavid.Entity.Docente> getDocente() {
        return Docente;
    }

    public void setDocente(Set<com.trazavid.Entity.Docente> docente) {
        Docente = docente;
    }

    public Set<com.trazavid.Entity.Asignatura> getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(Set<com.trazavid.Entity.Asignatura> asignatura) {
        Asignatura = asignatura;
    }
}
