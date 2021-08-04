package com.trazavid.Service;

import com.trazavid.Entity.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SalonService {
    public Iterable<Salon> findAll();

    public Page<Salon> findAll(Pageable pageable);


    public Optional<Salon> findById(Long id) ;

    public Salon save(Salon user);

    public void deleteById(Long id) ;
}
