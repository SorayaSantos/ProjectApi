package io.altar.jseproject.business;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Collection;

import io.altar.jseproject.dto.ProductDTO;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class ProductBusiness {

	//final static ShelfBusiness shelfBusiness = new ShelfBusiness();
	@Inject
	ProductRepository productRepository1;
//	final static ProductRepository productRepository1 = ProductRepository.getInstance();
	//final static ShelfRepository shelfRepository1 = ShelfRepository.getInstance();
	@Inject
	ShelfRepository shelfRepository1;
	
	@Transactional
	public void createProduct(Product product) {
		List<Shelf> shelvesList;
		List<Shelf> newShelvesList = new ArrayList<Shelf>();
		shelvesList = product.getShelvesList();

		if (shelvesList.size() > 0) {
			for (Shelf shelf : shelvesList) {
				newShelvesList.add(shelf);
			}
			for (Shelf shelf : shelvesList) {
				if (shelf.getProduct() == null) {
					shelf.setProduct(product);
					shelfRepository1.editEntity(shelf);
				} else {
					newShelvesList.remove(shelf);
					product.setShelvesList(newShelvesList);
					productRepository1.editEntity(product);
				}
			}
		}

		productRepository1.createEntities(product);

	}

	public List<ProductDTO> consultProducts() {

		List<Product> products= productRepository1.consultEntities();
		List<ProductDTO> productsDTO=new ArrayList<>();

		for (Product product :products) {
			productsDTO.add(new ProductDTO(product.getId(),product.getDiscount(),product.getIva(),product.getPvp()));
		}
			return productsDTO;	
	}

	public ProductDTO consultProductById(long id) {
		Product product = productRepository1.consultEntityById(id);
		return new ProductDTO(product.getId(),product.getDiscount(),product.getIva(),product.getPvp());
	}
	@Transactional
	public void deleteProduct(long id) {
		List<Shelf> shelvesList;
		shelvesList = productRepository1.consultEntityById(id).getShelvesList();
		if (shelvesList != null) {
			for (Shelf shelf : shelvesList) {
				shelf.setProduct(null);
				shelfRepository1.editEntity(shelf);
			}
		}
		productRepository1.removeEntityById(id);
	}
	@Transactional
	public void editProduct(Product product) {
		long id = product.getId();
		List<Shelf> oldShelvesList;
		List<Shelf> newShelvesList;
		newShelvesList = product.getShelvesList();
		oldShelvesList = productRepository1.consultEntityById(id).getShelvesList();

		for (Shelf shelf : oldShelvesList) {
			shelf.setProduct(null);
			shelfRepository1.editEntity(shelf);
		}
		for (Shelf shelf : newShelvesList) {
			shelf.setProduct(product);
			shelfRepository1.editEntity(shelf);
		}
		productRepository1.editEntity(product);
	}
}
