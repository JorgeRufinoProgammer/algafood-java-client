package com.algaworks.algafood.client.model.input;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteInput {
	
	private String nome;
	private BigDecimal taxaFrete;
	private CozinhaInput cozinha;
	private EnderecoInput endereco;
}
