package br.com.nexfar.api.Api.domain;

import lombok.Data;

@Data
public class ProductDTO {

	Integer productId;
	String name; 
	Double price; 
	Double taxe;
}
