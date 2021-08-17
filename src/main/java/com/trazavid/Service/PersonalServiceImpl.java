package com.trazavid.Service;

import com.trazavid.Entity.Personal;
import com.trazavid.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonalServiceImpl implements PersonalService {
    @Autowired
    private PersonalRepository personalRepository;
    @Override
    public Iterable<Personal> findAll() {
        return personalRepository.findAll();
    }

    @Override
    public Page<Personal> findAll(Pageable pageable) {
        return personalRepository.findAll(pageable);
    }

    @Override
    public Optional<Personal> findById(Long id) {
        return personalRepository.findById(id);
    }

    @Override
    public Personal save(Personal personal) {
        return personalRepository.save(personal);
    }

    @Override
    public void deleteById(Long id) {
        personalRepository.deleteById(id);
    }
}
