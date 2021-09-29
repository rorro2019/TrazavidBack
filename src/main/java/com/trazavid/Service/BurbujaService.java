package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Burbuja;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BurbujaService {
    public Iterable<Burbuja> findAll();

    public List<Burbuja> findById_institucion(Long id_institucion);
    public Page<Burbuja> findAll(Pageable pageable);

    public Optional<Burbuja> findById(Long id) ;

    public Burbuja save(Burbuja burbuja);

    public void deleteById(Long id) ;
}
