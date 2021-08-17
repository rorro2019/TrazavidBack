package com.trazavid.Service;

import com.trazavid.Entity.Personal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface PersonalService {
    public Iterable<Personal> findAll();

    public Page<Personal> findAll(Pageable pageable);

    public Optional<Personal> findById(Long id) ;

    public Personal save(Personal personal);

    public void deleteById(Long id) ;
}
