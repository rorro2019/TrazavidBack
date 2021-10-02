package com.trazavid.Repository;

import com.trazavid.Entity.CasoPositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoPositivoRepository extends JpaRepository<CasoPositivo,Long> {
}
