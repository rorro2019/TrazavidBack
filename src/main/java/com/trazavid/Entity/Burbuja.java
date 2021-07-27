package com.trazavid.Entity;

import javax.persistence.*;

@Entity
@Table(name ="Burbuja")
public class Burbuja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_burbuja;

}
