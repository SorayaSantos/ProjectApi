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

import io.altar.jseproject.business.ShelfBusiness;
import io.altar.jseproject.dto.ShelfDTO;
import io.altar.jseproject.model.Shelf;

@Path("/shelves")
public class ShelfServices {
	@Inject
	ShelfBusiness shelfBusiness;
//	ShelfBusiness shelfBusiness = new ShelfBusiness();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createShelf(Shelf shelf) {
		shelfBusiness.createShelf(shelf);
	}
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDTO> consultShelves() {
		return shelfBusiness.consultShelves();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ShelfDTO consultShelfById(@PathParam("id") long id) {
		return shelfBusiness.consultShelfById(id);
	}
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteShelf(@PathParam("id") long id) {
		shelfBusiness.deleteShelf(id);
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
	public void editShelf(Shelf shelf) {
		shelfBusiness.editShelf(shelf);
	}
	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ShelfDTO>  consultListOfShelvesByProductId(@PathParam("id") long id) {
		return shelfBusiness.consultListOfShelvesByProductId(id);
	}
}
