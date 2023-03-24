package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteResumo {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private Cozinha cozinha;
}
