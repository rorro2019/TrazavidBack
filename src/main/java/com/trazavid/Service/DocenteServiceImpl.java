package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Docente;
import com.trazavid.Repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements DocenteService {
    @Autowired
    private DocenteRepository docenteRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Docente> findAll(Pageable pageable) {
        return docenteRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Docente> findById(Long id) {
        return docenteRepository.findById(id);
    }

    @Override
    public List<Docente> findById_institucion(Long id_institucion) {
        return docenteRepository.findById_institucion(id_institucion);
    }
    @Override
    @Transactional
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        docenteRepository.deleteById(id);
    }
}
