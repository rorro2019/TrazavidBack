package com.trazavid.Controller;


import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Salon;
import com.trazavid.Service.CursoService;
import com.trazavid.Service.SalonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin("*")
public class CursoController {

    @Resource
    private CursoService cursoService;
    @Resource
    private SalonService salonService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Curso curso){
     //   if ( salonService.findById(curso.getSalon().getId_salon()) == null) {
     //       Optional<Salon> salon = salonService.findById(curso.getSalon().getId_salon());
            curso.setSalon(salonService.save(curso.getSalon()));
     //   };
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));

    }

    @GetMapping(value = "/all")
    public Iterable<Curso> getAll() {
        return cursoService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long cursooId){
        Optional<Curso> oCurso= cursoService.findById(cursooId);
        if(!oCurso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCurso);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long cursooId) {
        if(!cursoService.findById(cursooId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        cursoService.deleteById(cursooId);
        return ResponseEntity.ok().build();
    }


}
