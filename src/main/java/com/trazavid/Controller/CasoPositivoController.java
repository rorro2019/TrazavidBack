package com.trazavid.Controller;

import com.trazavid.Entity.*;
import com.trazavid.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/casopositivo")
@CrossOrigin("*")
public class CasoPositivoController {

    @Resource
    private CursoService cursoService;
    @Resource
    private SalonService salonService;
    @Resource
    private InstitucionService institucionService;
    @Resource
    private AlumnoService alumnoService;
    @Resource
    private DocenteService docenteService;
    @Resource
    private BurbujaService burbujaService;
    @Resource
    private CasoPositivoService casoPositivoService;

    static final String BODY = String.join(
            System.getProperty("line.separator"),
            "<h1>Amazon SES SMTP Email Test</h1>",
            "<p>This email was sent with Amazon SES using the ",
            "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
            " for <a href='https://www.java.com'>Java</a>."
    );
    //create a new line
    @PostMapping(value="/new")
    public ResponseEntity<?> create (@Valid @RequestBody CasoPositivo casoPositivo){
      /**  if (!casoPositivo.getAlumno().equals(null)){
          alumnoService.save(casoPositivo.getAlumno()) ;
            Long id = casoPositivo.getAlumno().getId_institucion() ;
            List<Burbuja> burbujas= burbujaService.findById_institucion(id);
            int j;
            for (j=0; j < burbujas.size(); j++) {
                Set<Alumno> toList = burbujas.get(j).getAlumnos() ;
                List<Alumno>  alumnos = new ArrayList<>(toList);
                int i;
                for (i=0; i < alumnos.size(); i++) {
                   if( alumnos.get(i).getId_alumno()== casoPositivo.getAlumno().getId_alumno() ){

                       Optional<Burbuja> burbuja= burbujaService.findById(burbujas.get(j).getId_burbuja());
                       List<Alumno>  alumnosList = new ArrayList<>(burbuja.get().getAlumnos());
                       int z;
                       for (z=0; z < burbuja.get().getAlumnos().size(); z++) {
                           String destinatario = alumnosList.get(z).getEmail(); //A quien le quieres escribir.
                           String asunto = "Caso Positivo Covid";
                           String cuerpo = "Estimado " + alumnosList.get(z).getApellido() +" "+
                                   alumnosList.get(z).getNombre()   +", le informamos que en los ultimos dias se detecto un caso positivo en su burbuja." +
                                   "" +
                                   "Le recomendamos que siga las siguientes instrucciones para prevenir contagios ...";
                           enviarConGMail(destinatario, asunto, cuerpo);
                       }
                       List<Docente>  docentessList = new ArrayList<>(burbuja.get().getDocentes());
                       int k;
                       for (k=0; k < burbuja.get().getDocentes().size(); k++) {
                           String destinatario = docentessList.get(k).getEmail(); //A quien le quieres escribir.
                           String asunto = "Caso Positivo Covid";
                           String cuerpo = "Estimado " + docentessList.get(z).getApellido() +" "+
                                   docentessList.get(z).getNombre()   + ", le informamos que en los ultimos dias se detecto un caso positivo en su burbuja." +
                           "" +
                                   "Le recomendamos que siga las siguientes instrucciones para prevenir contagios ...";
                           enviarConGMail(destinatario, asunto, cuerpo);
                       }
                    }
                }
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(casoPositivoService.save(casoPositivo)) ;
        } ;
        if (!casoPositivo.getDocente().equals(null)){
            docenteService.save(casoPositivo.getDocente());
            Long id = casoPositivo.getDocente().getId_institucion() ;
            List<Burbuja> burbujas= burbujaService.findById_institucion(id);
            int j;
            for (j=0; j < burbujas.size(); j++) {
                Set<Docente> toList = burbujas.get(j).getDocentes() ;
                List<Docente>  docentes = new ArrayList<>(toList);
                int i;
                for (i=0; i < docentes.size(); i++) {
                    if( docentes.get(i).getId_docente() == casoPositivo.getDocente().getId_docente() ){

                        Optional<Burbuja> burbuja= burbujaService.findById(burbujas.get(j).getId_burbuja());
                        List<Alumno>  alumnosList = new ArrayList<>(burbuja.get().getAlumnos());
                        int z;
                        for (z=0; z < burbuja.get().getAlumnos().size(); z++) {
                            String destinatario = alumnosList.get(z).getEmail(); //A quien le quieres escribir.
                            String asunto = "Caso Positivo Covid";
                            String cuerpo = "Estimado " + alumnosList.get(z).getApellido() +" "+
                                    alumnosList.get(z).getNombre()   + ", le informamos que en los ultimos dias se detecto un caso positivo en su burbuja." +
                                    "" +
                                    "Le recomendamos que siga las siguientes instrucciones para prevenir contagios ...";
                            enviarConGMail(destinatario, asunto, cuerpo);
                        }
                        List<Docente>  docentessList = new ArrayList<>(burbuja.get().getDocentes());
                        int k;
                        for (k=0; k < burbuja.get().getDocentes().size(); k++) {
                            String destinatario = docentessList.get(k).getEmail(); //A quien le quieres escribir.
                            String asunto = "Caso Positivo Covid";
                            String cuerpo = "Estimado " + docentessList.get(z).getApellido() +" "+
                                    docentessList.get(z).getNombre()   +  ", le informamos que en los ultimos dias se detecto un caso positivo en su burbuja." +
                                    "" +
                                    "Le recomendamos que siga las siguientes instrucciones para prevenir contagios ...";
                            enviarConGMail(destinatario, asunto, cuerpo);
                        }
                    }
                }
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(casoPositivoService.save(casoPositivo)) ;
        } ;**/

        if (!casoPositivo.getAlumno().equals(null)){
            alumnoService.save(casoPositivo.getAlumno()) ; }
        else if (!casoPositivo.getDocente().equals(null)){;
            docenteService.save(casoPositivo.getDocente()); };

        return ResponseEntity.status(HttpStatus.CREATED).body(casoPositivoService.save(casoPositivo)) ;

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
    @GetMapping("/prueba")
    public void read (){

        String destinatario =  "rodrigosebastianzalazar@gmail.com"; //A quien le quieres escribir.
        String asunto = "Caso Positivo Covid";
        String cuerpo = "Estimado Fulanito, le informamos que en los ultimos dias se detecto un caso positivo en su burbuja. Siga las siguientes instrucciones para prevenir contagios";

        enviarConGMail(destinatario, asunto, cuerpo);
    }

    public void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
       // String remitente = "trazavidapp@gmail.com";  //Para la dirección nomcuenta@gmail.com

        String remitente = "trazavidapp@hotmail.com";
        Properties props = System.getProperties();
       // props.put("mail.smtp.host", "smtp-relay.gmail.com");  //El servidor SMTP de Google
        //props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.host", "smtp.live.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.user", "81f88e77a642a4");

        //props.put("mail.smtp.clave", "mwrrhkzyonripbpw");    //La clave de la cuenta
        props.put("mail.smtp.clave", "trazavid2021");
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
           // message.addRecipient(Message.RecipientType.TO,new InternetAddress("terepetrovich@gmail.com"));
            message.setSubject(asunto);
          //  message.setContent(BODY,"text/html");
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.live.com", remitente, "trazavid2021");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
}
