package io.altar.jseproject.business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import io.altar.jseproject.dto.ProductDTO;
import io.altar.jseproject.dto.ShelfDTO;
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

	public List<ShelfDTO> consultShelves() {
		Collection<Shelf> shelves= shelfRepository1.consultEntities();
		List<ShelfDTO> shelvesDTO=new ArrayList<>();
		for (Shelf shelf :shelves) {
			Product product = shelf.getProduct();
			ProductDTO productDTO = new ProductDTO(product.getId(),product.getDiscount(),product.getIva(),product.getPvp());
			shelvesDTO.add(new ShelfDTO(shelf.getId(),shelf.getCapacity(),productDTO,shelf.getPrice()));
		}
		return shelvesDTO;
	}

	public ShelfDTO consultShelfById(long id) {
		Shelf shelf = shelfRepository1.consultEntityById(id);
		Product product = shelf.getProduct();
		ProductDTO productDTO = new ProductDTO(product.getId(),product.getDiscount(),product.getIva(),product.getPvp());
		return new ShelfDTO(shelf.getId(),shelf.getCapacity(),productDTO,shelf.getPrice());
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

	public List<Shelf> consultListOfShelvesByProductId(long id) {
		Product product = productRepository.consultEntityById(id);
		return product.getShelvesList();
	}
}
