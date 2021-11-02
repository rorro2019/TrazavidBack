package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Institucion;
import com.trazavid.Service.AlumnoService;
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
@RequestMapping("/api/alumnos")
@CrossOrigin("*")
public class AlumnoController {

    @Resource
    private AlumnoService alumnoService;
    @Resource
    private InstitucionService institucionService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Alumno alumno){
        Optional<Institucion> institucion= institucionService.findById(alumno.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<Alumno> arrayAlumno = institucion.get().getAlumno() ;
            alumnoService.save(alumno);
            arrayAlumno.add(alumno) ;
            institucion.get().setAlumno(arrayAlumno) ;

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }

    }

    @PostMapping(value="/list")
    public ResponseEntity<?> list (@Valid @RequestBody Set<Alumno> arrayAlumno){

        int j;
        List<Alumno> list = new ArrayList<Alumno>(arrayAlumno);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());
        Set<Alumno> listaOriginal = institucion.get().getAlumno() ;


        for (j=0; j<list.size(); j++) {
                alumnoService.save(list.get(j));
                 listaOriginal.add(list.get(j)) ;
            }
        institucion.get().setAlumno(listaOriginal) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }



    @GetMapping(value = "/all")
    public Iterable<Alumno> getAll() {
        return alumnoService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long alumnoId){
        Optional<Alumno> oAlumno= alumnoService.findById(alumnoId);
        if(!oAlumno.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }


    // Update an User
  /**  @PutMapping("/{id]")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long usuarioId){
        Optional<Usuario> usuario = usuarioService.findById(usuarioId);
        if(!usuario.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));

    } **/

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long alumnoId) {
        if(!alumnoService.findById(alumnoId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        alumnoService.deleteById(alumnoId);
        return ResponseEntity.ok().build();
    }

}
