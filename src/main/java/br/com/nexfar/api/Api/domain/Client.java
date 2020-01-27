package br.com.nexfar.api.Api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "clients")
public class Client {

	@Id
	private Integer idCliente;
	private String _Id;
	private String CNPJ;
	private String Nome;
}
