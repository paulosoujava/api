package br.com.nexfar.api.Api;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.nexfar.api.Api.config.Mongos;
import br.com.nexfar.api.Api.domain.ProductSellingRestrictions;
import br.com.nexfar.api.Api.domain.ResultSearchDTO;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
