package com.trazavid.Repository;

import com.trazavid.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SalonRepository extends JpaRepository<Salon, Long>{


}
