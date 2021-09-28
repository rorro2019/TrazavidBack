package com.trazavid;


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

	public static void main(String[] args) {
		SpringApplication.run(TrazavidApplication.class, args);


	}
}
