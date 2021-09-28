package com.trazavid.Controller;

import com.trazavid.Entity.ERole;
import com.trazavid.Entity.Institucion;
import com.trazavid.Entity.Role;
import com.trazavid.Entity.Salon;
import com.trazavid.Service.InstitucionService;
import com.trazavid.Service.RoleService;
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
@RequestMapping("/api/roles")
@CrossOrigin("*")
public class RoleController {
    @Resource
    private RoleService roleService;

    @GetMapping("/agregar")
    public void read (){
        Optional<Role> userRole= roleService.findByName(ERole.ROLE_USER);
        if(!userRole.isPresent()){
            Role roluser = new Role(ERole.ROLE_USER);
            roleService.save(roluser);
        }
        userRole= roleService.findByName(ERole.ROLE_MODERATOR);
        if(!userRole.isPresent()){
            Role rolModerator = new Role(ERole.ROLE_MODERATOR);
            roleService.save(rolModerator);
        }
        userRole= roleService.findByName(ERole.ROLE_ADMIN);
        if(!userRole.isPresent()){
            Role rolAdministrador = new Role(ERole.ROLE_ADMIN);
            roleService.save(rolAdministrador);
        }
    }




}
