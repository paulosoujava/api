package br.com.nexfar.api.Api.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.ToString;

@Data
@Document(collection = "productSellingRestrictions")
public class ProductSellingRestrictions {
	
	private Integer idCliente;
	private Integer idProduto;

}
