package com.trazavid.Controller;

import com.trazavid.Entity.*;
import com.trazavid.Service.AlumnoService;
import com.trazavid.Service.AsistenciaDocenteService;
import com.trazavid.Service.DocenteService;
import com.trazavid.Service.InstitucionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/asistenciaDocente")
@CrossOrigin("*")
public class AsistenciaDocenteController {

    @Resource
    private AsistenciaDocenteService asistenciaDocenteService;
    @Resource
    private InstitucionService institucionService;
    @Resource
    private DocenteService docenteService;

    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Docente docente){

        Optional<Institucion> institucion= institucionService.findById(docente.getId_institucion());

        if(!institucion.isPresent()){
            return ResponseEntity.notFound().build();
        } else {
            Long idInstitucion = docente.getId_institucion();
            //obtengo fecha del sistema
            Date myDate = new Date();
            String fecha= new SimpleDateFormat("dd-MM-yyyy").format(myDate);
            AsistenciaDocentePK asistenciaDocentePK= new AsistenciaDocentePK(fecha,idInstitucion );
            String id= idInstitucion+" & "+ fecha;
            Optional<AsistenciaDocente> asistenciaDocente= asistenciaDocenteService.findById(id);

            if(!asistenciaDocente.isPresent()){
                //aca creo y agrego
                AsistenciaDocente asistenciaDocenteNew =new AsistenciaDocente();

                asistenciaDocenteNew.setId_asistenciaDocente(id);
                asistenciaDocenteNew.setFecha(fecha);
                asistenciaDocenteNew.setId_institucion(idInstitucion);
                List<Docente>  docentesList = new ArrayList<>();
                Docente docenteReq= docente;
                docentesList.add(docenteReq);
                Set<Docente> lisDocentes = new HashSet<>(docentesList);
                asistenciaDocenteNew.setDocentes(lisDocentes);
                docenteService.save(docente);
                asistenciaDocenteService.save(asistenciaDocenteNew);
                Set<AsistenciaDocente> arrayDocente= institucion.get().getAsistenciaDocente();
                arrayDocente.add(asistenciaDocenteNew) ;
                institucion.get().setAsistenciaDocente(arrayDocente); ;

                return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));


            }else {
            //aca agrego
            Set<AsistenciaDocente> arrayDocente= institucion.get().getAsistenciaDocente();
                //aca creo y agrego
                Set<Docente> docentesList = asistenciaDocente.get().getDocentes() ;;
                docentesList.add(docente);
                asistenciaDocente.get().setDocentes(docentesList);
                //docenteService.save(docente);
                asistenciaDocenteService.save(asistenciaDocente.get());

                arrayDocente.add(asistenciaDocente.get()) ;
                institucion.get().setAsistenciaDocente(arrayDocente); ;

                return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion.get()));

        }
    }
    }

    @GetMapping(value = "/all")
    public Iterable<AsistenciaDocente> getAll() {
        return asistenciaDocenteService.findAll();
    }

   /** @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long alumnoId){
        Optional<AsistenciaDocente> oAlumno= asistenciaDocenteService.findById(alumnoId);
        if(!oAlumno.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oAlumno);
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long alumnoId) {
        if(!asistenciaDocenteService.findById(alumnoId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        asistenciaDocenteService.deleteById(alumnoId);
        return ResponseEntity.ok().build();
    }**/
}
