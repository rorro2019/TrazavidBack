package com.trazavid.Service;

import com.trazavid.Entity.Asignatura;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AsignaturaService {
    public Iterable<Asignatura> findAll();

    public Page<Asignatura> findAll(Pageable pageable);

    public Optional<Asignatura> findById(Long id) ;

    public Asignatura save(Asignatura user);

    public void deleteById(Long id) ;
}
