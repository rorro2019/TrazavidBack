package com.trazavid;

import com.trazavid.Entity.Alumno;
import com.trazavid.Entity.ERole;
import com.trazavid.Entity.Institucion;
import com.trazavid.Entity.Role;
import com.trazavid.Service.AsignaturaService;
import com.trazavid.Service.RoleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class TrazavidApplication {
	private static RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(TrazavidApplication.class, args);
		//Role userRole = roleService.findByName(ERole.ROLE_USER)
		//		.orElseThrow(() -> new RuntimeException("Error: Role is not found."));

		Optional<Role> userRole= roleService.findByName(ERole.ROLE_USER);
		if(!userRole.isPresent()){
			roleService.save(userRole.get());
		}
		 userRole= roleService.findByName(ERole.ROLE_MODERATOR);
		if(!userRole.isPresent()){
			roleService.save(userRole.get());
		}
		userRole= roleService.findByName(ERole.ROLE_ADMIN);
		if(!userRole.isPresent()){
			roleService.save(userRole.get());
		}


	}
}
