package com.cmarinre.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.cmarinre.model.Persona;

public interface AccesoService {

	CompletableFuture<List<Persona>> llamadaServicio(Persona persona);

	CompletableFuture<List<Persona>> buscarPorEdadesAsync(int edad1, int edad2);

}