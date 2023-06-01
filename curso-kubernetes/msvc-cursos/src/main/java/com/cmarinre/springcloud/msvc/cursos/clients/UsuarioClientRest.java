package com.cmarinre.springcloud.msvc.cursos.clients;

import com.cmarinre.springcloud.msvc.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="msvc-usuarios", url="localhost:8001")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id);

    @PostMapping("/")
    public Usuario save(@RequestBody Usuario usuario);

}
