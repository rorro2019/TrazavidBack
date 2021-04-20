package com.trazavid.Controller;

import com.trazavid.Entity.User;
import com.trazavid.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping()
    public Page<User> getPage(Pageable pageable) {
        return userService.findAll(pageable);
    }
    //create a new user
    @PostMapping
    public ResponseEntity<?> create (@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    //read an user
    @GetMapping("/{id}")
    public ResponseEntity<?> read (@PathVariable(value = "id") Long userId){
        Optional<User> oUser= userService.findById(userId);
        if(!oUser.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oUser);
    }

    // Update an User
    @PutMapping("/{id]")
    public ResponseEntity<?> update (@RequestBody User userDetails, @PathVariable(value = "id") Long userId){
        Optional<User> user = userService.findById(userId);
        if(!user.isPresent()){
            return ResponseEntity.notFound().build();
        }
        user.get().setUsername(userDetails.getUsername());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
    }

    // Delete an User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable(value= "id") Long userId) {
        if(!userService.findById(userId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
