package com.trazavid.Repository;



import com.trazavid.Entity.AsistenciaAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface AsistenciaAlumnoRepository extends JpaRepository<AsistenciaAlumno,Long> , JpaSpecificationExecutor<AsistenciaAlumno> {

    @Query(nativeQuery = true,value = " select  * from AsistenciaAlumno where id_curso = ? ")
    List<AsistenciaAlumno> findById_curso(Long id_curso);
}
