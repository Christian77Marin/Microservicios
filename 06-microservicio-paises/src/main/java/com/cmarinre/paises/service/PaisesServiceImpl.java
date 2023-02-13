package com.cmarinre.paises.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmarinre.paises.model.Pais;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class PaisesServiceImpl implements PaisesService {

	String url = "https://restcountries.com/v2/all";
	
	@Autowired
	RestTemplate template;
	
	@Override
	public List<Pais> obtenerPaises(){
		String resultado = template.getForObject(url,String.class);
		ObjectMapper maper = new ObjectMapper();
		List<Pais> paises = new ArrayList<>();
		ArrayNode array;
		
		try {
			array = (ArrayNode)maper.readTree(resultado);
			for(Object ob:array) {
				ObjectNode json = (ObjectNode) ob;
				
				String capital = "";
				
				capital = (json.get("capital") == null) ? "Sin Capital" : json.get("capital").asText();
				
				
				
				
				paises.add(new Pais(json.get("name").asText(),
						capital,
						json.get("population").asInt(),
						json.get("flag").asText()));
			}
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return paises;
		
	}
	
	@Override
	public List<Pais> buscarPaises(String name){
		return obtenerPaises().stream().filter(p -> p.getNombre().contains(name)).collect(Collectors.toList());
	}
	
}
