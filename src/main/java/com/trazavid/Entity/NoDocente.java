package com.trazavid.Entity;


import javax.persistence.*;

@Entity
@Table(name ="NoDocente")
public class NoDocente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_nodocente;
}
