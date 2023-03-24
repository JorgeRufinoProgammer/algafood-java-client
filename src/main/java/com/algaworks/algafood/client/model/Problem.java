package com.algaworks.algafood.client.model;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Problem {
	
	private Integer status;
	private String userMessage;
	private OffsetDateTime timestamp;
	private List<Fields> fields;

	@Data
	public static class Fields {
		private String name;
		private String userMessage;
	}
}
