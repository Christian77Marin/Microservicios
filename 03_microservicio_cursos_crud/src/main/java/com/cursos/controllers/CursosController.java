package com.cursos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.model.Curso;

import jakarta.annotation.PostConstruct;

@RestController
public class CursosController {
	
	private List<Curso> cursos;
	@PostConstruct
	public void init() {
		cursos = new ArrayList<>();
		cursos.add(new Curso("Spring", 100, "Tarde"));
		cursos.add(new Curso("JavaScript", 60, "Mañana"));
		cursos.add(new Curso("C#", 50, "Mañana"));
		cursos.add(new Curso("GoLang", 25, "Tarde"));
		cursos.add(new Curso("TypeScript", 300, "Mañana"));
		cursos.add(new Curso("Angular", 200, "Mañana"));
		cursos.add(new Curso("Tailwind", 20, "Tarde"));
		cursos.add(new Curso("Spring", 23, "Mañana"));
	}
	
	@GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos(){
		return cursos;
	}
	
	@GetMapping(value="curso", produces = MediaType.APPLICATION_XML_VALUE) //--> Añadiendo la libreria jackson del pom e indicando el mediatype como xml se hace la conversion a xml automaticamente
	public Curso getCurso() {
		return new Curso("Java", 100, "mañana");
	}
	
	@GetMapping(value="cursos/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursos(@PathVariable("name") String nombre){
		List<Curso> aux = new ArrayList<>();
		for(Curso c: cursos) { // --> Recorre toda la lista 
			if(c.getNombre().equals(nombre)) {
				aux.add(c);
			}
		}
		return aux;
	}
	
	@DeleteMapping(value="curso/{name}")
	public void eliminarCurso(@PathVariable("name") String nombre) {
		cursos.removeIf(c -> c.getNombre().equals(nombre));
	}
	
	@PostMapping(value="curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso){
		cursos.add(curso);
		return cursos;
	}
	
	@PutMapping(value="curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> actualizaCurso(@RequestBody Curso curso){

		for(int i=0; i<cursos.size();i++) {
			if(cursos.get(i).getNombre().equals(curso.getNombre())) {
				cursos.set(i,curso);
			}
		}
		
		return cursos;
	}
	

}
