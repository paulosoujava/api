package br.com.nexfar.api.Api.domain;

import lombok.Data;

@Data
public class Taxes {
	
	private String _Id;
	private Integer clientId;
	private String type;
	private Integer percentage;
}
