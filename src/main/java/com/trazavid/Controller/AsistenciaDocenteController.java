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

    @GetMapping("/ausentes/{id}")
    public List<Docente> read (@PathVariable(value = "id") Long institucionId){
        Optional<Institucion> institucion= institucionService.findById(institucionId);

        if(!institucion.isPresent()){
            return null;
        } else{
            //obtengo fecha del sistema
            Date myDate = new Date();
            String fecha= new SimpleDateFormat("dd-MM-yyyy").format(myDate);
            String id= institucionId+" & "+ fecha;
            Optional<AsistenciaDocente> asistenciaDocente= asistenciaDocenteService.findById(id);
            if(!asistenciaDocente.isPresent()){
                Set<Docente> docentes = institucion.get().getDocente();
                List<Docente>  docentesLista = new ArrayList<>(docentes);
                return docentesLista;
            }else {
                Set<Docente> docentes = institucion.get().getDocente();
                Set<Docente> docentesPresentes= asistenciaDocente.get().getDocentes();
                List<Docente>  docentesLista = new ArrayList<>(docentes);
                List<Docente>  docentesListaPresentes = new ArrayList<>(docentesPresentes);
                Boolean  salida = docentesLista.removeAll(docentesListaPresentes) ;
                if (salida==true) {
                    return docentesLista;
                }else{
                    return null;
                }

            }
        }

    }

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

/**
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
