package com.cmarinre.springcloud.msvc.cursos.models.entity;

import com.cmarinre.springcloud.msvc.cursos.models.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "curso_id")
    private List<CursoUsuario> usuariosDelCurso;

    @Transient
    private List<Usuario> usuarios;

    public Curso() {

        usuariosDelCurso = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addCursoUsuario(CursoUsuario cursoUsuario){
        usuariosDelCurso.add(cursoUsuario);
    }

    public void removeCursoUsuario(CursoUsuario cursoUsuario){
        usuariosDelCurso.remove(cursoUsuario);
    }

    public List<CursoUsuario> getUsuariosDelCurso() {
        return usuariosDelCurso;
    }

    public void setUsuariosDelCurso(List<CursoUsuario> usuariosDelCurso) {
        this.usuariosDelCurso = usuariosDelCurso;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
