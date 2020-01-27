package br.com.nexfar.api.Api.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nexfar.api.Api.domain.Client;
import br.com.nexfar.api.Api.domain.ClientDTO;
import br.com.nexfar.api.Api.domain.ProductDTO;
import br.com.nexfar.api.Api.domain.Products;
import br.com.nexfar.api.Api.domain.ResultSearchDTO;
import br.com.nexfar.api.Api.service.repository.ClientRepository;
import br.com.nexfar.api.Api.service.repository.ProdSelResRepository;
import br.com.nexfar.api.Api.service.repository.ProductRepository;

@Service
public class MyService {

	@Autowired
	private ProductRepository repository;
	
		
	public List<ResultSearchDTO> getProduct(String name, String idCLient){
	return repository.findByTaxe(name, idCLient);
	}
}
