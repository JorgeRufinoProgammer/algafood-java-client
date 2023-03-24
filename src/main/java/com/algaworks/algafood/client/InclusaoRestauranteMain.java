package com.algaworks.algafood.client;

import java.math.BigDecimal;

import org.springframework.web.client.RestTemplate;

import com.algaworks.algafood.client.api.ClientApiException;
import com.algaworks.algafood.client.api.RestauranteClient;
import com.algaworks.algafood.client.model.Restaurante;
import com.algaworks.algafood.client.model.input.CidadeInput;
import com.algaworks.algafood.client.model.input.CozinhaInput;
import com.algaworks.algafood.client.model.input.EnderecoInput;
import com.algaworks.algafood.client.model.input.RestauranteInput;

public class InclusaoRestauranteMain {
	
	public static void main(String args[]) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			RestauranteClient restauranteClient = new RestauranteClient("http://api.algafood.local:8080", restTemplate);
			
			RestauranteInput restauranteInput = new RestauranteInput();
			restauranteInput.setNome("Delicias Paraenses");
			restauranteInput.setTaxaFrete(new BigDecimal("5.0"));
			
			CozinhaInput cozinha = new CozinhaInput();
			cozinha.setId(4L);
			
			CidadeInput cidade = new CidadeInput();
			cidade.setId(6L);
			
			EnderecoInput endereco = new EnderecoInput();
			endereco.setCep("68795-000");
			endereco.setLogradouro("Av. João Fanjas");
			endereco.setNumero("136");
			endereco.setBairro("Centro");
			endereco.setCidade(cidade);
			
			restauranteInput.setCozinha(cozinha);
			restauranteInput.setEndereco(endereco);
			
			Restaurante novoRestaurante = restauranteClient.adicionar(restauranteInput);
			
			System.out.println(novoRestaurante);
			
		} catch (ClientApiException e) {
			if (e.getProblem() != null) {
				System.out.println(e.getProblem().getUserMessage());
				
				if(e.getProblem().getFields() != null) {
					e.getProblem().getFields().stream()
					.forEach(field -> System.out.println(field.getUserMessage()));
				}
			} else {
				System.out.println("Erro desconhecido");
				e.printStackTrace();
			}
		}
	}
}
