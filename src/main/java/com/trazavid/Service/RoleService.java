package com.trazavid.Service;

import com.trazavid.Entity.ERole;
import com.trazavid.Entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RoleService {
    public Iterable<Role> findAll();

    public Page<Role> findAll(Pageable pageable);

    public Optional<Role> findByName(ERole name);

    public Optional<Role> findById(Integer id) ;

    public Role save(Role user);

    public void deleteById(Integer id) ;
}
