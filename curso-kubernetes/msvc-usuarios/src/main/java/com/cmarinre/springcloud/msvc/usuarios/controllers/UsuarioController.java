package com.cmarinre.springcloud.msvc.usuarios.controllers;


import com.cmarinre.springcloud.msvc.usuarios.models.entity.Usuario;
import com.cmarinre.springcloud.msvc.usuarios.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){
        Optional<Usuario> userOptional= service.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.ok(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@Valid @RequestBody Usuario user, BindingResult result){



        if(result.hasErrors()){
            return validate(result);
        }

        if(!user.getEmail().isBlank() && service.existePorEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Ya existe un usuario con ese email"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Usuario user, @PathVariable Long id, BindingResult result){



        if(result.hasErrors()){
            return validate(result);
        }


        Optional<Usuario> o = service.findById(id);
        if(o.isPresent()){
            Usuario usuarioDb = o.get();
            if(service.findByEmail(user.getEmail()).isPresent() && !user.getEmail().equalsIgnoreCase(usuarioDb.getEmail())){
                return ResponseEntity.badRequest().body(Collections.singletonMap("Error","Ya existe un usuario con ese email"));
            }
            usuarioDb.setNombre(user.getNombre());
            usuarioDb.setEmail(user.getEmail());
            usuarioDb.setPassword(user.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> o = service.findById(id);
        if(o.isPresent()){
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String,String> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errores.put(error.getField(),"El campo " + error.getField() + " " + error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }



}
