package br.com.nexfar.api.Api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
public class ClientDTO {

	private Integer idCliente;
	private String cnpj;
	private String name;

	public ClientDTO(Client client) {
		this.idCliente = client.getIdCliente();
		this.cnpj = client.getCNPJ();
		this.name = client.getNome();
	}
}
