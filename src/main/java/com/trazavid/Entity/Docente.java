package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Docente")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_docente;


}
