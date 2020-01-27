package br.com.nexfar.api.Api.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.nexfar.api.Api.domain.Client;
import br.com.nexfar.api.Api.domain.ClientDTO;
import br.com.nexfar.api.Api.domain.Products;


public interface ClientRepository extends MongoRepository<Client, Integer>{
	
}
