package com.trazavid.Service;

import com.trazavid.Entity.Alumno;
import com.trazavid.Repository.AlumnoRepository;
import com.trazavid.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AlumnoServiceImpl implements AlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public List<Alumno> findById_institucion(Long id_institucion) {
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
    public Page<Alumno> findAll(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumno> findById(Long id) {
        return alumnoRepository.findById(id);
    }

    @Override
    @Transactional
    public Alumno save(Alumno alumno) {

        return alumnoRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        alumnoRepository.deleteById(id);
    }
}
