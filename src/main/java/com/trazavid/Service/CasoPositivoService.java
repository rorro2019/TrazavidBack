package com.trazavid.Service;

import com.trazavid.Entity.Burbuja;
import com.trazavid.Entity.CasoPositivo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CasoPositivoService {

    public Iterable<CasoPositivo> findAll();

     public List<CasoPositivo> findById_institucion(Long id_institucion);

    public Page<CasoPositivo> findAll(Pageable pageable);

    public Optional<CasoPositivo> findById(Long id) ;

    public CasoPositivo save(CasoPositivo casoPositivo);

    public void deleteById(Long id) ;
}
