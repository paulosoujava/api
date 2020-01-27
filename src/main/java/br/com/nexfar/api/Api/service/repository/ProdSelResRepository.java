package br.com.nexfar.api.Api.service.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.nexfar.api.Api.domain.Products;
import br.com.nexfar.api.Api.domain.ProductSellingRestrictions;

public interface ProdSelResRepository extends CrudRepository<ProductSellingRestrictions, String>{
}
