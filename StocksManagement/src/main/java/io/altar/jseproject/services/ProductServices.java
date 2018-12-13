package io.altar.jseproject.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.ProductBusiness;
import io.altar.jseproject.dto.ProductDTO;
import io.altar.jseproject.model.Product;

@Path("/products")
public class ProductServices {
	@Inject
	ProductBusiness productBusiness;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createProduct(Product product) {
		productBusiness.createProduct(product);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductDTO> consultProducts() {
		return productBusiness.consultProducts();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductDTO consultProductById(@PathParam("id") long id) {
		return productBusiness.consultProductById(id);
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteProductById(@PathParam("id") long id) {
		productBusiness.deleteProduct(id);
		return "Product deleted";
	}
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public void editProductById(Product product) {
		productBusiness.editProduct(product);
	}
	

}
