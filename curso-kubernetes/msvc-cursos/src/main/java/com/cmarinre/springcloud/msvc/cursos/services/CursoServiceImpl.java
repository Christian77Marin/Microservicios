package com.cmarinre.springcloud.msvc.cursos.services;

import com.cmarinre.springcloud.msvc.cursos.entity.Curso;
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
}
