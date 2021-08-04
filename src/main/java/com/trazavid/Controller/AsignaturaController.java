package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Asignatura;
import com.trazavid.Service.AlumnoService;
import com.trazavid.Service.AsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/asignatura")
@CrossOrigin("*")
public class AsignaturaController {
    @Resource
    private AsignaturaService asignaturaService;


    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Asignatura asignatura){
        return ResponseEntity.status(HttpStatus.CREATED).body(asignaturaService.save(asignatura));

    }

    @GetMapping(value = "/all")
    public Iterable<Asignatura> getAll() {
        return asignaturaService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long asignaturaId){
        Optional<Asignatura> oAlumno= asignaturaService.findById(asignaturaId);
        if(!oAlumno.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long asignaturaId) {
        if(!asignaturaService.findById(asignaturaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        asignaturaService.deleteById(asignaturaId);
        return ResponseEntity.ok().build();
    }


}
