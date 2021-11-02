package com.trazavid.Service;

import com.trazavid.Entity.AsistenciaAlumno;
import com.trazavid.Entity.AsistenciaDocente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AsistenciaDocenteService {
    public Iterable<AsistenciaDocente> findAll();

    public List<AsistenciaDocente> findById_institucion(Long id_institucion);
    public Page<AsistenciaDocente> findAll(Pageable pageable);

    public Optional<AsistenciaDocente> findById(Long id) ;

    public AsistenciaDocente save(AsistenciaDocente user);

    public void deleteById(Long id) ;

}
