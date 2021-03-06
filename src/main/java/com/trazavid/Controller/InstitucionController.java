package com.trazavid.Controller;

import com.trazavid.Entity.*;
import com.trazavid.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/instituciones")
@CrossOrigin("*")
public class InstitucionController {

    @Resource
    private InstitucionService institucionService;
    @Resource
    private SalonService salonService;
    @Resource
    private AlumnoService alumnoService;
    @Resource
    private DocenteService docenteService;
    @Resource
    private CursoService cursoService;
    @Resource
    private BurbujaService burbujaService;
    @Resource
    private CasoPositivoService casoPositivoService;
    @Resource
    private AsistenciaDocenteService asistenciaDocenteService;
    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody Institucion institucion){
        Salon[] array= institucion.getSalon().toArray(new Salon[0]);
        int i;
        for (i=0; i<array.length; i++) {
            salonService.save(array[i]);
            System.out.println(array[i]);
        }
        Alumno[] arrayAlumno= institucion.getAlumno().toArray(new Alumno[0]);
        int j;
        for (j=0; j<arrayAlumno.length; j++) {
            alumnoService.save(arrayAlumno[j]);
            System.out.println(arrayAlumno[j]);
        }
        Curso[] arrayCurso= institucion.getCurso().toArray(new Curso[0]);
        int y;
        for (y=0; y<arrayCurso.length; y++) {

            arrayCurso[y].setSalon(salonService.save(arrayCurso[y].getSalon()));
            cursoService.save(arrayCurso[y]);
            System.out.println(arrayCurso[y]);
        }
        Docente[] arrayDocente= institucion.getDocente().toArray(new Docente[0]);
        int w;
        for (w=0; w<arrayDocente.length; w++) {
            docenteService.save(arrayDocente[w]);
            System.out.println(arrayDocente[w]);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(institucionService.save(institucion));
    }

    @GetMapping(value = "/all")
    public Iterable<Institucion> getAll() {
        return institucionService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long institucionId){
        Optional<Institucion> oInstitucion= institucionService.findById(institucionId);
        if(!oInstitucion.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oInstitucion);
    }

    @GetMapping("/personal/{id}")
    public ResponseEntity<?> readInstitucion (@PathVariable(value = "id") Long institucionId){
        Optional<Institucion> oInstitucion= institucionService.findByIdPersonal(institucionId);
        if(!oInstitucion.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oInstitucion);
    }

    @GetMapping("/alumnos/{id}")
    public Iterable<Alumno> readAlumnos (@PathVariable(value = "id") Long institucionId){
       return alumnoService.findById_institucion(institucionId);
    }

    @GetMapping("/asistenciaDocente/{id}")
    public Iterable<AsistenciaDocente> readAsistenciaDocentes (@PathVariable(value = "id") Long institucionId){
        return asistenciaDocenteService.findById_institucion(institucionId);
    }

    @GetMapping("/docentes/{id}")
    public Iterable<Docente> readDocentes (@PathVariable(value = "id") Long institucionId){
        return docenteService.findById_institucion(institucionId);
    }

    @GetMapping("/cursos/{id}")
    public Iterable<Curso> readCursos (@PathVariable(value = "id") Long institucionId){
        return cursoService.findById_institucion(institucionId);
    }

    @GetMapping("/salones/{id}")
    public Iterable<Salon> readSalones (@PathVariable(value = "id") Long institucionId){
        return salonService.findById_institucion(institucionId);
    }

    @GetMapping("/casospositivos/{id}")
    public Iterable<CasoPositivo> readCasosPositivos (@PathVariable(value = "id") Long institucionId){
        return casoPositivoService.findById_institucion(institucionId);
    }
    @GetMapping("/burbujas/{id}")
    public Iterable<Burbuja> readBurbujas (@PathVariable(value = "id") Long institucionId){
        return burbujaService.findById_institucion(institucionId);
    }


    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long institucionId) {
        if(!institucionService.findById(institucionId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        institucionService.deleteById(institucionId);
        return ResponseEntity.ok().build();
    }


}
