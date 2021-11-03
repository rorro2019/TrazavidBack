package com.trazavid.Repository;


import com.trazavid.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
@Query(nativeQuery = true,value = " select  * from Curso where id_institucion = ? ")
List<Curso> findById_institucion(Long id_institucion);
}
