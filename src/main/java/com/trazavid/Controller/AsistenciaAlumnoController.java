package com.trazavid.Controller;

import com.trazavid.Entity.*;
import com.trazavid.Service.*;
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
@RequestMapping("/api/asistenciaAlumno")
@CrossOrigin("*")
public class AsistenciaAlumnoController {
    @Resource
    private AsistenciaAlumnoService asistenciaAlumnoService;
    @Resource
    private CursoService cursoService;

    @Resource
    private AlumnoService alumnoService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody AsistenciaAlumno asistenciaAlumno){
        Optional<Curso> curso= cursoService.findById(asistenciaAlumno.getId_curso());
        if(!curso.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<AsistenciaAlumno> arrayAsistencia = curso.get().getAsistenciaAlumno() ;
            int y;
            for (y=0; y< asistenciaAlumno.getAlumnos().size(); y++) {
                Alumno[] arrayAlumnos= asistenciaAlumno.getAlumnos().toArray(new Alumno[0]);
                alumnoService.save(arrayAlumnos[y]);

            }
            asistenciaAlumnoService.save(asistenciaAlumno);
            arrayAsistencia.add(asistenciaAlumno) ;
            curso.get().setAsistenciaAlumno(arrayAsistencia);

            return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso.get()));
        }

    }


    @GetMapping(value = "/all")
    public Iterable<AsistenciaAlumno> getAll() {
        return asistenciaAlumnoService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long asignaturaId){
        Optional<AsistenciaAlumno> oAlumno= asistenciaAlumnoService.findById(asignaturaId);
        if(!oAlumno.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long asignaturaId) {
        if(!asistenciaAlumnoService.findById(asignaturaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        asistenciaAlumnoService.deleteById(asignaturaId);
        return ResponseEntity.ok().build();
    }


}
