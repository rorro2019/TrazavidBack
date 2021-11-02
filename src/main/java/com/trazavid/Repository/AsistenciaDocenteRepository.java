package com.trazavid.Repository;

import com.trazavid.Entity.AsistenciaAlumno;
import com.trazavid.Entity.AsistenciaDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaDocenteRepository extends JpaRepository<AsistenciaDocente,Long> , JpaSpecificationExecutor<AsistenciaDocente> {

    @Query(nativeQuery = true,value = " select  * from AsistenciaDocente where id_institucion = ? ")
    List<AsistenciaDocente> findById_institucion(Long id_institucion);
}
