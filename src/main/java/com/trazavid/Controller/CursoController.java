package com.trazavid.Controller;


import com.trazavid.Entity.*;
import com.trazavid.Service.AsistenciaAlumnoService;
import com.trazavid.Service.CursoService;
import com.trazavid.Service.InstitucionService;
import com.trazavid.Service.SalonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin("*")
public class CursoController {

    @Resource
    private CursoService cursoService;
    @Resource
    private SalonService salonService;
    @Resource
    private InstitucionService institucionService;
    @Resource
    private AsistenciaAlumnoService asistenciaAlumnoService;
    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Curso curso){
        Optional<Institucion> institucion= institucionService.findById(curso.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<Curso> arrayCurso = institucion.get().getCurso() ;
            curso.setSalon(salonService.save(curso.getSalon()));
            cursoService.save(curso);
            arrayCurso.add(curso) ;
            institucion.get().setCurso(arrayCurso);

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }


    }
    @PostMapping(value="/list")
    public ResponseEntity<?> list (@Valid @RequestBody Set<Curso> arrayCurso){

        int j;
        List<Curso> list = new ArrayList<Curso>(arrayCurso);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());
        Set<Curso> listaOriginal = institucion.get().getCurso() ;

        for (j=0; j<list.size(); j++) {
            list.get(j).setSalon(salonService.save(list.get(j).getSalon()));
            cursoService.save(list.get(j));
            listaOriginal.add(list.get(j)) ;
        }
        institucion.get().setCurso(listaOriginal) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
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

    @GetMapping("/asistenciaAlumno/{id}")
    public Iterable<AsistenciaAlumno> readAsistenciaAlumnos (@PathVariable(value = "id") Long cursoid){
        return asistenciaAlumnoService.findById_curso(cursoid);
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
