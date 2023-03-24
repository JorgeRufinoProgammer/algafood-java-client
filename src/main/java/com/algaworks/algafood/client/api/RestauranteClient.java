package com.algaworks.algafood.client.api;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.model.Restaurante;
import com.algaworks.algafood.client.model.RestauranteResumo;
import com.algaworks.algafood.client.model.input.RestauranteInput;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteClient {
	
	private static final String RESOURCE_PATH = "/restaurantes";
	
	private String url;
	
//	Esta classe ajuda a fazer requisiçoes web
	private RestTemplate restTemplate; 
		
	public List<RestauranteResumo> listar(){
		try {
//		URI onde será feito o GET
			URI resourceUri =URI.create(url + RESOURCE_PATH);
			
//		Faz o "get" na uri e deserealiza os objetos em um array 
			RestauranteResumo[] restaurantes = restTemplate.getForObject(resourceUri, RestauranteResumo[].class);
			
			return Arrays.asList(restaurantes);
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
	
	public Restaurante adicionar (RestauranteInput restauranteInput) {
		try {
			URI resourceUri =URI.create(url + RESOURCE_PATH);
			
			Restaurante restaurante = restTemplate.postForObject(resourceUri, restauranteInput, Restaurante.class);
			
			return restaurante;
			
		} catch (RestClientResponseException e) {
			throw new ClientApiException(e.getMessage(), e);
		}
	}
}
