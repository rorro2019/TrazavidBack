package com.trazavid.Repository;

import com.trazavid.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
    @Query(nativeQuery = true,value = " select  * from Salon where id_institucion = ? ")
    List<Salon> findById_institucion(Long id_institucion);

}
