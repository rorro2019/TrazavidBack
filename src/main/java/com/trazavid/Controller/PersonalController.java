package com.trazavid.Controller;

import com.trazavid.Entity.Personal;
import com.trazavid.Service.PersonalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/personales")
@CrossOrigin("*")
public class PersonalController {


    @Resource
    private PersonalService personalService;


    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Personal personal){
        return ResponseEntity.status(HttpStatus.CREATED).body(personalService.save(personal));

    }

    @GetMapping(value = "/all")
    public Iterable<Personal> getAll() {
        return personalService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long personalId){
        Optional<Personal> oCurso= personalService.findById(personalId);
        if(!oCurso.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oCurso);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long personalId) {
        if(!personalService.findById(personalId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        personalService.deleteById(personalId);
        return ResponseEntity.ok().build();
    }

}
