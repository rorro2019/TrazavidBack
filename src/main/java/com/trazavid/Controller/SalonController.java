package com.trazavid.Controller;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.Docente;
import com.trazavid.Entity.Institucion;
import com.trazavid.Entity.Salon;
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
@RequestMapping("/api/salones")
@CrossOrigin("*")
public class SalonController {
    @Resource
    private SalonService salonService;

    @Resource
    private InstitucionService institucionService;
    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Salon salon){
        Optional<Institucion> institucion= institucionService.findById(salon.getId_institucion());
        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Set<Salon> arraySalon = institucion.get().getSalon() ;
            salonService.save(salon);
            arraySalon.add(salon) ;
            institucion.get().setSalon(arraySalon) ;

            return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
        }
    }

    @PostMapping(value="/list")
    public ResponseEntity<?> list (@Valid @RequestBody Set<Salon> arraySalon){

        int j;
        List<Salon> list = new ArrayList<Salon>(arraySalon);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());
        Set<Salon> listaOriginal = institucion.get().getSalon() ;

        for (j=0; j<list.size(); j++) {
            salonService.save(list.get(j));
            listaOriginal.add(list.get(j)) ;
        }
        institucion.get().setSalon(listaOriginal) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));
    }

    @PostMapping(value="/editlist")
    public ResponseEntity<?> editlist (@Valid @RequestBody Set<Salon> arraySalon){

        int j;
        List<Salon> list = new ArrayList<Salon>(arraySalon);

        Optional<Institucion> institucion= institucionService.findById(list.get(0).getId_institucion());

        for (j=0; j<list.size(); j++) {
            salonService.save(list.get(j));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.findById(list.get(0).getId_institucion()));
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
