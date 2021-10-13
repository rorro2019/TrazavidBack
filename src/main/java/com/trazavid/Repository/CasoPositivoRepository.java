package com.trazavid.Repository;

import com.trazavid.Entity.CasoPositivo;
import com.trazavid.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CasoPositivoRepository extends JpaRepository<CasoPositivo,Long>, JpaSpecificationExecutor<CasoPositivo> {
    @Query(nativeQuery = true,value = " select  * from CasoPositivo where id_institucion = ? ")
    List<CasoPositivo> findById_institucion(Long id_institucion);
}
