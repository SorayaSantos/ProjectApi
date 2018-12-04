package io.altar.jseproject.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.model.Product;

@Path("/products")
public class ProductServices {

	ProductBusiness business = new ProductBusiness();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product createProduct(Product product) {
		business.createProduct(product);
		return product;
	}

}
