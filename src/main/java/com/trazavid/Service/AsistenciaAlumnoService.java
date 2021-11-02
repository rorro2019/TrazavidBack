package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.AsistenciaAlumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AsistenciaAlumnoService {

    public Iterable<AsistenciaAlumno> findAll();

    public List<AsistenciaAlumno> findById_curso(Long id_institucion);
    public Page<AsistenciaAlumno> findAll(Pageable pageable);

    public Optional<AsistenciaAlumno> findById(Long id) ;

    public AsistenciaAlumno save(AsistenciaAlumno user);

    public void deleteById(Long id) ;


}
