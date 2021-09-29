package com.trazavid.Service;

import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Docente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    public Iterable<Curso> findAll();

    public List<Curso> findById_institucion(Long id_institucion);

    public Page<Curso> findAll(Pageable pageable);

    public Optional<Curso> findById(Long id) ;

    public Curso save(Curso curso);

    public void deleteById(Long id) ;
}
