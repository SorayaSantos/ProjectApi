package io.altar.jseproject.dto;

import io.altar.jseproject.model.Entity;
public class ShelfDTO extends Entity{
	private static final long serialVersionUID=1L;

	private long id;
	private long capacity;
	private ProductDTO productDTO;
	private double price;
	public ShelfDTO(){}
	
	public ShelfDTO(long id,long capacity, ProductDTO productDTO, double price) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.productDTO = productDTO;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public ProductDTO getProduct() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		if(productDTO==null){
			return " Shelf [capacity=" + capacity + ", product=none product stored" + ", price=" + price + "]";
		}
		else{
			return " Shelf [capacity=" + capacity + ", product=" + productDTO.toString() + ", price=" + price + "]";
		}
	}
}
