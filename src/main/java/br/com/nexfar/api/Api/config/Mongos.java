package br.com.nexfar.api.Api.config;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.AggregationOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import br.com.nexfar.api.Api.domain.Client;
import br.com.nexfar.api.Api.domain.Products;
import br.com.nexfar.api.Api.domain.ProductSellingRestrictions;
import br.com.nexfar.api.Api.domain.ResultSearchDTO;
import br.com.nexfar.api.Api.domain.Taxes;

public class Mongos {
	// MongoClient mongoClient = new MongoClient(new
	// MongoClientURI("mongodb://localhost:27017"));
	MongoClient mongoClient = new MongoClient();
	DB database = mongoClient.getDB("Nexfar-CargaDados");
	DBCollection collection;

	public List<ResultSearchDTO> searchProducByName(String nome, String idCLient) {

		List<ResultSearchDTO> pDTO = new ArrayList<>();

		BasicDBObject query = new BasicDBObject();
		query.put("name", Pattern.compile("^.*" + nome + ".*$", Pattern.CASE_INSENSITIVE));
		collection = database.getCollection("products");
		Cursor cursor = collection.find(query);
		while (cursor.hasNext()) {
			BasicDBObject document = (BasicDBObject) cursor.next();
			Products p = new Products();
			p.set_id(document.get("_id").toString());
			p.setName(document.get("name").toString());
			p.setPrice(Double.parseDouble(document.get("price").toString()));
			p.setProductId(Integer.parseInt(document.get("productId").toString()));
			ResultSearchDTO r = new ResultSearchDTO();
			r.setProducts(p);
			r.setTaxe(checkRestrictions(idCLient, p));
				pDTO.add(r);
		}

		return pDTO;

	}

	public Double checkRestrictions(String idCliente, Products p) {

		collection = database.getCollection("productSellingRestrictions");
		BasicDBObject query = new BasicDBObject();
		query.put("idCliente", "138");
		query.put("idProduto", "23215");
		Cursor cursor = collection.find(query);
		while (cursor.hasNext()) {
			double taxe = calculateTaxes(idCliente, p);
			return taxe;
		}
		return 0.0;

	}

	private double calculateTaxes(String idCliente, Products p) {
		collection = database.getCollection("taxes");
		BasicDBObject query = new BasicDBObject();
		query.put("clientId", idCliente);
		Cursor cursor = collection.find(query);

		Integer ipi = 0;
		Integer icms = 0;

		while (cursor.hasNext()) {
			BasicDBObject document = (BasicDBObject) cursor.next();
			if (!document.isEmpty()) {

				if (document.get("type").toString().equals("ICMS")) {
					icms = Integer.parseInt(document.get("percentage").toString());

				}

				if (document.get("type").toString().equals("IPI")) {
					ipi = Integer.parseInt(document.get("percentage").toString());

				}

			}
		}

		double xIcms = icms;
		double hundred = 100;
		double totalPart1 = xIcms / hundred;
		double newValue = p.getPrice();
		double xIpi = ipi;
		double totalPart2 = xIpi / hundred;
		double result = newValue + (newValue * totalPart1) + (newValue * totalPart2);
		return round(result, 2);

	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	public boolean hasClient(String idCliente) {
		collection = database.getCollection("clients");
		BasicDBObject query = new BasicDBObject();
		query.put("idCliente", idCliente);
		Cursor cursor = collection.find(query);
		while (cursor.hasNext()) {
			BasicDBObject document = (BasicDBObject) cursor.next();
			if (!document.isEmpty()) {
				Client c = new Client();
				c.setCNPJ(document.get("CNPJ").toString());
				c.setIdCliente(Integer.parseInt(document.get("idCliente").toString()));
				c.setNome(document.get("Nome").toString());
				c.set_Id(document.get("_id").toString());
				return true;
			}

		}
		return false;

	}

}