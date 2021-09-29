package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Burbuja;
import com.trazavid.Entity.Docente;
import com.trazavid.Repository.AlumnoRepository;
import com.trazavid.Repository.BurbujaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BurbujaServiceImpl implements BurbujaService{

    @Autowired
    private BurbujaRepository burbujaRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Burbuja> findAll() {
        return burbujaRepository.findAll();
    }

    @Override
    public List<Burbuja> findById_institucion(Long id_institucion) {
        return burbujaRepository.findById_institucion(id_institucion);
    }

    /** @Override
    @Transactional(readOnly = true)
    public List<Alumno> findById_institucionIn(Long id_institucion) {
        List<Alumno> lista = null ; //= alumnoRepository.findById_institucionIn(id_institucion) ;
            return lista;
    }**/

    @Override
    @Transactional(readOnly = true)
    public Page<Burbuja> findAll(Pageable pageable) {
        return burbujaRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Burbuja> findById(Long id) {
        return burbujaRepository.findById(id);
    }

    @Override
    @Transactional
    public Burbuja save(Burbuja alumno) {
        return burbujaRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        burbujaRepository.deleteById(id);
    }
}
