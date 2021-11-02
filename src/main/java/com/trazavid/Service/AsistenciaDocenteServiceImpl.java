package com.trazavid.Service;

import com.trazavid.Entity.AsistenciaAlumno;
import com.trazavid.Entity.AsistenciaDocente;
import com.trazavid.Repository.AsistenciaAlumnoRepository;
import com.trazavid.Repository.AsistenciaDocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class AsistenciaDocenteServiceImpl implements AsistenciaDocenteService{

    @Autowired
    private AsistenciaDocenteRepository alumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<AsistenciaDocente> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public List<AsistenciaDocente> findById_institucion(Long id_institucion) {
        return alumnoRepository.findById_institucion(id_institucion);
    }

    /** @Override
     @Transactional(readOnly = true)
     public List<Alumno> findById_institucionIn(Long id_institucion) {
     List<Alumno> lista = null ; //= alumnoRepository.findById_institucionIn(id_institucion) ;
     return lista;
     }**/

    @Override
    @Transactional(readOnly = true)
    public Page<AsistenciaDocente> findAll(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsistenciaDocente> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public AsistenciaDocente save(AsistenciaDocente asistenciaDocente) {

        return alumnoRepository.save(asistenciaDocente);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
