package com.trazavid.Controller;

import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Docente;
import com.trazavid.Service.CursoService;
import com.trazavid.Service.DocenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/docentes")
@CrossOrigin("*")
public class DocenteController {

    @Resource
    private DocenteService docenteService;


    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Docente docente){
        return ResponseEntity.status(HttpStatus.CREATED).body(docenteService.save(docente));

    }

    @GetMapping(value = "/all")
    public Iterable<Docente> getAll() {
        return docenteService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long docenteId){
        Optional<Docente> oCurso= docenteService.findById(docenteId);
        if(!oCurso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCurso);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long docenteId) {
        if(!docenteService.findById(docenteId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        docenteService.deleteById(docenteId);
        return ResponseEntity.ok().build();
    }

}
