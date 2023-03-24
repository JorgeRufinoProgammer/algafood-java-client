package com.algaworks.algafood.client.api;

import org.springframework.web.client.RestClientResponseException;

import com.algaworks.algafood.client.model.Problem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	@Getter
	private Problem problem;
	
	public ClientApiException(String message, RestClientResponseException cause) {
		super(message, cause);
				
		deserializeProblem(cause);
		System.out.println(cause);
	}	
	
//	Este metodo pega o erro recebido pela API e o converte em um objeto Problem
	private void deserializeProblem(RestClientResponseException cause) {
		ObjectMapper mapper = new ObjectMapper();
		
//		Configura o mapper para não falhar na desserializaçao caso encontre propriedades que não existam na classe "Problem"
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new JavaTimeModule());	//Permite a desserializacao para Datas
		mapper.findAndRegisterModules();
		
		try {
//			Le o a requisiçao, pega o body como String e converte para objeto Problem
			this.problem = mapper.readValue(cause.getResponseBodyAsString(), Problem.class); 		
		} catch (JsonProcessingException e) {
			log.warn("Não foi possível desserializar a resposta em um Problem", e);
		}
	}
}
