package com.trazavid.Controller;

import com.trazavid.Entity.*;
import com.trazavid.Service.AlumnoService;
import com.trazavid.Service.AsignaturaService;
import com.trazavid.Service.InstitucionService;
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
@RequestMapping("/api/asignaturas")
@CrossOrigin("*")
public class AsignaturaController {
    @Resource
    private AsignaturaService asignaturaService;
    @Resource
    private InstitucionService institucionService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Asignatura asignatura){
        Optional<Institucion> institucion= institucionService.findById(asignatura.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<Asignatura> arrayAsignatura = institucion.get().getAsignatura() ;
            asignaturaService.save(asignatura);
            arrayAsignatura.add(asignatura) ;
            institucion.get().setAsignatura(arrayAsignatura);

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }

    }
    @PostMapping(value="/list")
    public ResponseEntity<?> list (@Valid @RequestBody Set<Asignatura> arrayAsignatura){

        int j;
        List<Asignatura> list = new ArrayList<Asignatura>(arrayAsignatura);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());
        Set<Asignatura> listaOriginal = institucion.get().getAsignatura() ;

        for (j=0; j<list.size(); j++) {
            asignaturaService.save(list.get(j));
            listaOriginal.add(list.get(j)) ;
        }
        institucion.get().setAsignatura(listaOriginal) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
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
