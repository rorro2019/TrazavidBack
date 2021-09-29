package com.trazavid.Repository;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Institucion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long>, JpaSpecificationExecutor<Alumno> {
    // consulta difusa
    @Query(nativeQuery = true,value = " select  * from Alumno where id_institucion = ? ")
    List<Alumno> findById_institucion(Long id_institucion);
}
