package com.cmarinre.springcloud.msvc.cursos.services;

import com.cmarinre.springcloud.msvc.cursos.clients.UsuarioClientRest;
import com.cmarinre.springcloud.msvc.cursos.models.Usuario;
import com.cmarinre.springcloud.msvc.cursos.models.entity.Curso;
import com.cmarinre.springcloud.msvc.cursos.models.entity.CursoUsuario;
import com.cmarinre.springcloud.msvc.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoRepository repo;

    @Autowired
    private UsuarioClientRest client;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return (List<Curso>) repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return repo.save(curso);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId) {

        //Curso
        Optional<Curso> o = repo.findById(cursoId);
        if(o.isPresent()){

            //usuario recogido del servicio Usuarios
            Usuario usuarioMsvc = client.findById(usuario.getId());

            //Curso Recogido
            Curso curso = o.get();

            //Relacion entre curso y usuario
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repo.save(curso);

            return Optional.of(usuarioMsvc);
        }

        return Optional.empty();

    }

    @Override
    public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {

        //Curso
        Optional<Curso> o = repo.findById(cursoId);
        if(o.isPresent()){

            //usuario recogido del servicio Usuarios
            Usuario usuarioNuevoMsvc = client.save(usuario);

            //Curso Recogido
            Curso curso = o.get();

            //Relacion entre curso y usuario
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioNuevoMsvc.getId());

            curso.addCursoUsuario(cursoUsuario);
            repo.save(curso);

            return Optional.of(usuarioNuevoMsvc);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Usuario> desasignarUsuario(Usuario usuario, Long cursoId) {
        //Curso
        Optional<Curso> o = repo.findById(cursoId);
        if(o.isPresent()){

            //usuario recogido del servicio Usuarios
            Usuario usuarioMsvc = client.findById(usuario.getId());

            //Curso Recogido
            Curso curso = o.get();

            //Relacion entre curso y usuario
            CursoUsuario cursoUsuario = new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMsvc.getId());

            curso.removeCursoUsuario(cursoUsuario);
            repo.save(curso);

            return Optional.of(usuarioMsvc);
        }

        return Optional.empty();
    }
}
