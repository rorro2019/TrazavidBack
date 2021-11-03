package com.trazavid.Repository;

import com.trazavid.Entity.Burbuja;
import com.trazavid.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BurbujaRepository extends JpaRepository<Burbuja, Long> {
    @Query(nativeQuery = true,value = " select  * from Burbuja where id_institucion = ? ")
    List<Burbuja> findById_institucion(Long id_institucion);

}
