package br.com.nexfar.api.Api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import br.com.nexfar.api.Api.config.Mongos;
import br.com.nexfar.api.Api.domain.ResultSearchDTO;

@RestController
public class Controller {

	@GetMapping("/")
	public String getHome() {
		return "http://localhost:8080/swagger-ui.html  <--  --> http://localhost:8080/api/search/";
	}
	/*
	 * IDCLIENT = 138  -> HEADER
	 * VENAFLON -> BODY
	 */
			

	@PostMapping("/api/product/search")
	public ResponseEntity<List<ResultSearchDTO>> searchProduct(
			@RequestHeader("clientId") int clientId,
			@RequestBody String name) 
	{
		Mongos m = new Mongos();
		String id = String.valueOf(clientId);
		if (m.hasClient(id)) {
			List<ResultSearchDTO> list = m.searchProducByName(name, id);
			if (list != null) {
				return ResponseEntity.ok(list);
			}
		}
		return ResponseEntity.noContent().build();
	}

}
