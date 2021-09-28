package com.trazavid.Service;

import com.trazavid.Entity.ERole;
import com.trazavid.Entity.Role;
import com.trazavid.Repository.PersonalRepository;
import com.trazavid.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Iterable<Role> findAll() {
        return null;
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(Integer id) {
      roleRepository.deleteById(id);
    }
}
