package com.trazavid.Service;

import com.trazavid.Entity.AsistenciaAlumno;
import com.trazavid.Repository.AsistenciaAlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaAlumnoServiceImpl implements AsistenciaAlumnoService{

    @Autowired
    private AsistenciaAlumnoRepository alumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<AsistenciaAlumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public List<AsistenciaAlumno> findById_curso(Long id_institucion) {
        return alumnoRepository.findById_curso(id_institucion);
    }

    /** @Override
     @Transactional(readOnly = true)
     public List<Alumno> findById_institucionIn(Long id_institucion) {
     List<Alumno> lista = null ; //= alumnoRepository.findById_institucionIn(id_institucion) ;
     return lista;
     }**/

    @Override
    @Transactional(readOnly = true)
    public Page<AsistenciaAlumno> findAll(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsistenciaAlumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public AsistenciaAlumno save(AsistenciaAlumno alumno) {

        return alumnoRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
