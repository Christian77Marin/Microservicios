package com.cmarinre.springcloud.msvc.usuarios.services;

import com.cmarinre.springcloud.msvc.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario user);
    void deleteById(Long id);
    Optional<Usuario> findByEmail(String email);
    boolean existePorEmail(String email);


}
