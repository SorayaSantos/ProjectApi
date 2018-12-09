package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;
import io.altar.jseproject.repositories.ProductRepository;

public class ShelfBusiness {
	static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	static ProductRepository productRepository = ProductRepository.getInstance();
	static ProductBusiness productBusiness = new ProductBusiness();

	public void createShelf(Shelf shelf) {

		if (shelf.getProduct() != null) {
			Product product = productRepository.consultEntityById(shelf.getProduct().getId());
			if (product != null) {

				shelfRepository1.createEntities(shelf);

				shelf.setProduct(product);

				ArrayList<Shelf> shelvesList;
				shelvesList = product.getShelvesList();
				shelvesList.add(shelf);
				product.setShelvesList(shelvesList);
			} else {
				shelf.setProduct(null);
			}

		} else {
			shelfRepository1.createEntities(shelf);
		}
	}

	public Collection<Shelf> consultShelves() {

		return shelfRepository1.consultEntities();
	}

	public Shelf consultShelfById(long id) {
		return shelfRepository1.consultEntityById(id);
	}

	public void deleteShelfById(long id) {
		Shelf shelf = shelfRepository1.consultEntityById(id);
		Product product = shelf.getProduct();
		if (product != null) {
			product.getShelvesList().remove(shelf);
		}
		shelfRepository1.removeEntityById(id);

	}

	public Shelf editShelfById(Shelf shelf) {
		Product oldProduct = null;
		long id = shelf.getId();
		Shelf shelfToBeChanged = shelfRepository1.consultEntityById(id);

		if (shelfToBeChanged.getProduct() != null) {
			oldProduct = shelfToBeChanged.getProduct();
			oldProduct.getShelvesList().remove(shelf);
		}
		Product newProduct = productRepository.consultEntityById(shelf.getProduct().getId());
		if (newProduct != null) {
			newProduct.getShelvesList().add(shelf);
			shelf.setProduct(newProduct);
		}
		shelfRepository1.editEntityById(id, shelf);
		return shelf;

	}

	public ArrayList<Shelf> consultListOfShelvesByProductId(long id) {
		Product product = productRepository.consultEntityById(id);
		return product.getShelvesList();
	}
}
