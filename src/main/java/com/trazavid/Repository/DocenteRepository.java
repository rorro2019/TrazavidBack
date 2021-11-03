package com.trazavid.Repository;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {
    @Query(nativeQuery = true,value = " select  * from Docente where id_institucion = ? ")
    List<Docente> findById_institucion(Long id_institucion);
}
