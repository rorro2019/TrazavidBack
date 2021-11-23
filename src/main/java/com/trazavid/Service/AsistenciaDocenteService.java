package com.trazavid.Service;

import com.trazavid.Entity.AsistenciaAlumno;
import com.trazavid.Entity.AsistenciaDocente;
import com.trazavid.Entity.AsistenciaDocentePK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AsistenciaDocenteService {
    public Iterable<AsistenciaDocente> findAll();

    public List<AsistenciaDocente> findById_institucion(Long id_institucion);
    public Page<AsistenciaDocente> findAll(Pageable pageable);

    Optional<AsistenciaDocente> findById(String id) ;

    public AsistenciaDocente save(AsistenciaDocente user);

    //public void deleteById(Long id) ;

}
