package com.trazavid.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
public class AsistenciaDocentePK implements Serializable {

    @JsonFormat(pattern="dd-MM-yyyy")
     String fecha;

     Long id_institucion;

    public AsistenciaDocentePK(String fecha, Long id_institucion) {
        this.fecha = fecha;
        this.id_institucion = id_institucion;
    }

    public AsistenciaDocentePK() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getId_institucion() {
        return id_institucion;
    }

    public void setId_institucion(Long id_institucion) {
        this.id_institucion = id_institucion;
    }
}