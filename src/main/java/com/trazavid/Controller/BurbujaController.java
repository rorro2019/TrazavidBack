package com.trazavid.Controller;

import com.trazavid.Entity.Burbuja;
import com.trazavid.Entity.Curso;
import com.trazavid.Entity.Institucion;
import com.trazavid.Service.BurbujaService;
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
@RequestMapping("/api/burbujas")
@CrossOrigin("*")
public class BurbujaController {

    @Resource
    private CursoService cursoService;
    @Resource
    private SalonService salonService;
    @Resource
    private InstitucionService institucionService;
    @Resource
    private BurbujaService burbujaService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Burbuja burbuja){
        return ResponseEntity.status(HttpStatus.CREATED).body(burbujaService.save(burbuja)) ;
    }



    @GetMapping(value = "/all")
    public Iterable<Burbuja> getAll() {
        return burbujaService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long burbujaId){
        Optional<Burbuja> oBurbuja= burbujaService.findById(burbujaId);
        if(!oBurbuja.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oBurbuja);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long burbujaId) {
        if(!burbujaService.findById(burbujaId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        burbujaService.deleteById(burbujaId);
        return ResponseEntity.ok().build();
    }


}
