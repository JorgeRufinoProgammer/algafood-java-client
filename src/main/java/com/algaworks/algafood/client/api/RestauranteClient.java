package com.algaworks.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.model.RestauranteResumoDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteClient {
	
	private static final String RESOURCE_PATH = "/restaurantes";
	
	private String url;
	
//	Esta classe ajuda a fazer requisiçoes web
	private RestTemplate restTemplate; 
		
	public List<RestauranteResumoDto> listar(){
//		URI onde será feito o GET
		URI resourceUri =URI.create(url + RESOURCE_PATH);
		
//		Faz o "get" na uri e deserealiza os objetos em um array 
		RestauranteResumoDto[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumoDto[].class);
		
		return Arrays.asList(restaurantes);
	}
}
