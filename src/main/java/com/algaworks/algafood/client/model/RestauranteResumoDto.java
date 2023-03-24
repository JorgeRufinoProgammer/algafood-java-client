package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteResumoDto {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private CozinhaDto cozinha;
}
