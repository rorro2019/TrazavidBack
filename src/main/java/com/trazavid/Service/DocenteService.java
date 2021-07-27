package com.trazavid.Service;

import com.trazavid.Entity.Docente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DocenteService {
    public Iterable<Docente> findAll();

    public Page<Docente> findAll(Pageable pageable);

    public Optional<Docente> findById(Long id) ;

    public Docente save(Docente docente);

    public void deleteById(Long id) ;
}
