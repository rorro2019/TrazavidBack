package com.trazavid.Repository;

import com.trazavid.Entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
}
