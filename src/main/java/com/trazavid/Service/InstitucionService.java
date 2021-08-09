package com.trazavid.Service;

import com.trazavid.Entity.Institucion;
import com.trazavid.Entity.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InstitucionService {

    public Iterable<Institucion> findAll();

    public Optional<Institucion> findByIdPersonal(Long id);

    public Page<Institucion> findAll(Pageable pageable);


    public Optional<Institucion> findById(Long id) ;

    public Institucion save(Institucion user);

    public void deleteById(Long id) ;

}
