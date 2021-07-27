package com.trazavid.Service;

import com.trazavid.Entity.Institucion;
import com.trazavid.Repository.InstitucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class InstitucionServiceImpl implements InstitucionService{
    @Autowired
    private InstitucionRepository institucionRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Institucion> findAll() {
        return institucionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Institucion> findAll(Pageable pageable) {
        return institucionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Institucion> findById(Long id) {
        return institucionRepository.findById(id);
    }

    @Override
    @Transactional
    public Institucion save(Institucion docente) {
        return institucionRepository.save(docente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        institucionRepository.deleteById(id);
    }
}
