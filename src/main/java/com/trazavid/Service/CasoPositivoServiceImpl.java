package com.trazavid.Service;

import com.trazavid.Entity.Burbuja;
import com.trazavid.Entity.CasoPositivo;
import com.trazavid.Repository.CasoPositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasoPositivoServiceImpl implements CasoPositivoService{

    @Autowired
    private CasoPositivoRepository casoPositivoRepository;

    @Override
    public Iterable<CasoPositivo> findAll() {
        return casoPositivoRepository.findAll();
    }

    /**  @Override
    public List<CasoPositivo> findById_institucion(Long id_institucion) {
        return null;
    }**/

    @Override
    public List<CasoPositivo> findById_institucion(Long id_institucion) {
        return casoPositivoRepository.findById_institucion(id_institucion);
    }


    @Override
    public Page<CasoPositivo> findAll(Pageable pageable) {
        return casoPositivoRepository.findAll(pageable);
    }

    @Override
    public Optional<CasoPositivo> findById(Long id) {
        return casoPositivoRepository.findById(id);
    }

    @Override
    public CasoPositivo save(CasoPositivo casoPositivo) {
        return casoPositivoRepository.save(casoPositivo);
    }

    @Override
    public void deleteById(Long id) {

    }
}
