package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

@Path("/shelves")
public class ShelfServices {
	ShelfBusiness shelfBusiness = new ShelfBusiness();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf createShelf(Shelf shelf) {
		shelfBusiness.createShelf(shelf);
		return shelf;
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Shelf> consultShelves() {
		return shelfBusiness.consultShelves();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf consultShelfById(@PathParam("id") long id) {
		return shelfBusiness.consultShelfById(id);
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteShelfById(@PathParam("id") long id) {
		shelfBusiness.deleteShelfById(id);
		return "Shelf deleted";
	}
	@GET
	@Path("/health")
	@Produces(MediaType.TEXT_PLAIN)
	public String health() {
		return "healthy";
	}
	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Shelf editShelfById(Shelf shelf) {
		shelfBusiness.editShelfById(shelf);
		return shelf;
	}
	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Shelf>  consultListOfShelvesByProductId(@PathParam("id") long id) {
		return shelfBusiness.consultListOfShelvesByProductId(id);
	}
}
