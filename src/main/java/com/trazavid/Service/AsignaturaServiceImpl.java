package com.trazavid.Service;

import com.trazavid.Entity.Asignatura;
import com.trazavid.Repository.AlumnoRepository;
import com.trazavid.Repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Asignatura> findAll() {
        return asignaturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Asignatura> findAll(Pageable pageable) {
        return asignaturaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    @Transactional
    public Asignatura save(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }

}
