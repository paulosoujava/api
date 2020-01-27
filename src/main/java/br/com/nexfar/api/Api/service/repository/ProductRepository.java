package br.com.nexfar.api.Api.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.nexfar.api.Api.domain.Products;
import br.com.nexfar.api.Api.domain.ResultSearchDTO;

public interface ProductRepository extends CrudRepository<ResultSearchDTO, Integer>{
	public List<ResultSearchDTO> findByTaxe(String nome, String idCLient);
}
