package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.AsistenciaDocente;
import com.trazavid.Entity.Institucion;
import com.trazavid.Service.AlumnoService;
import com.trazavid.Service.AsistenciaDocenteService;
import com.trazavid.Service.InstitucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/aiastenciaDocente")
@CrossOrigin("*")
public class AsistenciaDocenteController {

    @Resource
    private AsistenciaDocenteService asistenciaDocenteService;
    @Resource
    private InstitucionService institucionService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody AsistenciaDocente asistenciaDocente){
        Optional<Institucion> institucion= institucionService.findById(asistenciaDocente.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<AsistenciaDocente> arrayAlumno = institucion.get().getAsistenciaDocente();
            asistenciaDocenteService.save(asistenciaDocente);
            arrayAlumno.add(asistenciaDocente) ;
            institucion.get().setAsistenciaDocente(arrayAlumno); ;

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }
    }

    @GetMapping(value = "/all")
    public Iterable<AsistenciaDocente> getAll() {
        return asistenciaDocenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long alumnoId){
        Optional<AsistenciaDocente> oAlumno= asistenciaDocenteService.findById(alumnoId);
        if(!oAlumno.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long alumnoId) {
        if(!asistenciaDocenteService.findById(alumnoId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        asistenciaDocenteService.deleteById(alumnoId);
        return ResponseEntity.ok().build();
    }
}
