package io.altar.jseproject.business;

import java.util.ArrayList;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.repositories.ProductRepository;

public class ShelfBusiness {
	static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	static ProductBusiness productBusiness = new ProductBusiness();

public void createShelf(Shelf shelf) {
		
		//Product product = shelf.getProduct();
		//product = ProductBusiness.productRepository1.ConsultEntityById(product.getId());
		//shelf.setProduct(product);
		
		//ArrayList<Shelf> shelvesList = new ArrayList<Shelf>();
		//shelvesList = product.getShelves_list();
		//shelvesList.add(shelf);
		//product.setShelves_list(shelvesList);

		shelfRepository1.CreateEntities(shelf);

		}
}
