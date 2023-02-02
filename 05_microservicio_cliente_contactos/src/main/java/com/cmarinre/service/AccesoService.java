package com.cmarinre.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.cmarinre.model.Persona;

public interface AccesoService {

	CompletableFuture<List<Persona>> llamadaServicio(Persona persona);

}