package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Docente;
import com.trazavid.Entity.Institucion;
import com.trazavid.Service.CursoService;
import com.trazavid.Service.DocenteService;
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
@RequestMapping("/api/docentes")
@CrossOrigin("*")
public class DocenteController {

    @Resource
    private DocenteService docenteService;
    @Resource
    private InstitucionService institucionService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Docente docente){
        Optional<Institucion> institucion= institucionService.findById(docente.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<Docente> arrayDocente = institucion.get().getDocente() ;
            docenteService.save(docente);
            arrayDocente.add(docente) ;
            institucion.get().setDocente(arrayDocente);

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }

    }
    @PostMapping(value="/list")
    public ResponseEntity<?> list (@Valid @RequestBody Set<Docente> arrayDocente){

        int j;
        List<Docente> list = new ArrayList<Docente>(arrayDocente);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());
        Set<Docente> listaOriginal = institucion.get().getDocente() ;


        for (j=0; j<list.size(); j++) {
            docenteService.save(list.get(j));
            listaOriginal.add(list.get(j)) ;
        }
        institucion.get().setDocente(listaOriginal) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
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
