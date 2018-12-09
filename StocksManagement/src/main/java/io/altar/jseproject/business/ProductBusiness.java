package io.altar.jseproject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class ProductBusiness {

	static ShelfBusiness shelfBusiness = new ShelfBusiness();
	static ProductRepository productRepository1 = ProductRepository.getInstance();
	static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();

	public void createProduct(Product product) {
		ArrayList<Shelf> shelvesList;
		ArrayList<Shelf> newShelvesList = new ArrayList<Shelf>();
		shelvesList = product.getShelvesList();

		if (shelvesList != null && shelvesList.size() > 0) {
			for (Shelf shelf : shelvesList) {
				newShelvesList.add(shelf);
			}
			for (Shelf shelf : shelvesList) {
				if (shelf.getProduct() == null) {
					shelf.setProduct(product);
				} else {
					newShelvesList.remove(shelf);
					product.setShelvesList(newShelvesList);
				}
			}
		}

		productRepository1.createEntities(product);

	}

	public Collection<Product> consultProducts() {

		return productRepository1.consultEntities();
	}

	public Product consultProductById(long id) {
		return productRepository1.consultEntityById(id);
	}

	public void deleteProductById(long id) {
		ArrayList<Shelf> shelvesList;
		shelvesList = productRepository1.consultEntityById(id).getShelvesList();
		if (shelvesList != null) {
			for (Shelf shelf : shelvesList) {
				shelf.setProduct(null);
			}
		}
		productRepository1.removeEntityById(id);
	}

	public Product editProductById(Product product) {
		long id = product.getId();
		ArrayList<Shelf> oldShelvesList;
		ArrayList<Shelf> newShelvesList;
		newShelvesList = product.getShelvesList();
		oldShelvesList = productRepository1.consultEntityById(id).getShelvesList();

		for (Shelf shelf : oldShelvesList) {
			shelf.setProduct(null);
		}
		for (Shelf shelf : newShelvesList) {
			shelf.setProduct(product);
		}
		productRepository1.editEntityById(id, product);
		return product;
	}
}
