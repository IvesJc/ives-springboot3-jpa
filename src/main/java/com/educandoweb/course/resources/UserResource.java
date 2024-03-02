package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController = Recurso WEB que é controlado por controlador REST
@RestController
// @ResquestMapping = path dessa requisição
@RequestMapping(value = "/users")
public class UserResource {

    // @GetMapping = Método que responde a requisição GET do HTTP
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
        return ResponseEntity.ok().body(u);
    }

}
