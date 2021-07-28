package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/alumnos")
@CrossOrigin("*")
public class AlumnoController {
    @Resource
    private AlumnoService alumnoService;


    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Alumno alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));

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
