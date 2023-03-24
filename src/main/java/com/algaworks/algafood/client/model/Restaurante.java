package com.algaworks.algafood.client.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Restaurante {
	
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private Cozinha cozinha;
	private Endereco endereco;
	private boolean ativo;
	private boolean aberto;
}
