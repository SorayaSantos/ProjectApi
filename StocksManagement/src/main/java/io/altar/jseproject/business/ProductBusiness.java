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
		ArrayList<Long> shelvesList;
		ArrayList<Long> newShelvesList = new ArrayList<Long>();
		shelvesList = product.getShelves_list();

		if (shelvesList != null && shelvesList.size() > 0) {
			for (Long idShelf : shelvesList) {
				newShelvesList.add(idShelf);
			}
			for (Long idShelf : shelvesList) {
				Shelf shelf = shelfRepository1.consultEntityById(idShelf);
				if (shelfRepository1.consultEntityById(idShelf) != null && shelf.getProduct() == null) {
					shelf.setProduct(product);
				} else {
					newShelvesList.remove(idShelf);
					product.setShelves_list(newShelvesList);
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
		ArrayList<Long> shelvesList;
		shelvesList = productRepository1.consultEntityById(id).getShelves_list();
		if (shelvesList != null) {
			for (Long idShelf : shelvesList) {
				Shelf shelf = ShelfBusiness.shelfRepository1.consultEntityById(idShelf);
				shelf.setProduct(null);
			}
		}
		productRepository1.removeEntityById(id);
	}

	public Product editProductById(Product product) {
		long id = product.getId();
		ArrayList<Long> oldShelvesList;
		ArrayList<Long> newShelvesList;
		newShelvesList = product.getShelves_list();
		oldShelvesList = productRepository1.consultEntityById(id).getShelves_list();
		if (oldShelvesList != null) {
			for (Long idShelf : oldShelvesList) {
				Shelf shelf = ShelfBusiness.shelfRepository1.consultEntityById(idShelf);
				shelf.setProduct(null);
			}
		}
		if (newShelvesList != null) {
			for (Long idShelf : newShelvesList) {
				Shelf shelf = ShelfBusiness.shelfRepository1.consultEntityById(idShelf);
				shelf.setProduct(product);
			}
		}
		productRepository1.editEntityById(id, product);
		return product;
	}
}
