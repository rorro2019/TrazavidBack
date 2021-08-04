package com.trazavid.Service;

import com.trazavid.Entity.Institucion;
import com.trazavid.Entity.Salon;
import com.trazavid.Repository.InstitucionRepository;
import com.trazavid.Repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class SalonServiceImpl implements SalonService {
    @Autowired
    private SalonRepository salonRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Salon> findAll() {
        return salonRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Salon> findAll(Pageable pageable) {
        return salonRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Salon> findById(Long id) {
        return salonRepository.findById(id);
    }

    @Override
    @Transactional
    public Salon save(Salon docente) {
        return salonRepository.save(docente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        salonRepository.deleteById(id);
    }
}
