package br.com.nexfar.api.Api.domain;



import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "products")
public class Products {
	
	private String _id;
	private Integer productId;
	private String name;
	private Double price;

}
