package com.trazavid.Controller;

import com.trazavid.Entity.Salon;
import com.trazavid.Service.SalonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/salones")
@CrossOrigin("*")
public class SalonController {
    @Resource
    private SalonService salonService;


    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Salon salon){
        return ResponseEntity.status(HttpStatus.CREATED).body(salonService.save(salon));

    }

    @GetMapping(value = "/all")
    public Iterable<Salon> getAll() {
        return salonService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long salonId){
        Optional<Salon> oSalon= salonService.findById(salonId);
        if(!oSalon.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oSalon);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long salonId) {
        if(!salonService.findById(salonId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        salonService.deleteById(salonId);
        return ResponseEntity.ok().build();
    }

}
