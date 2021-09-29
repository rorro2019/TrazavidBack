package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AlumnoService {
    public Iterable<Alumno> findAll();

    public List<Alumno> findById_institucion(Long id_institucion);
    public Page<Alumno> findAll(Pageable pageable);

    public Optional<Alumno> findById(Long id) ;

    public Alumno save(Alumno user);

    public void deleteById(Long id) ;
}
