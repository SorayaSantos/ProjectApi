package io.altar.jseproject.dto;

import io.altar.jseproject.model.Product;

public class ShelfDTO extends EntityDTO{
	private long capacity;
	private Product product;
	private double price;
	public ShelfDTO(){}
	
	public ShelfDTO(long capacity, Product product, double price) {
		super();
		
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public ShelfDTO(long capacity, double price) {
		super();
		this.capacity = capacity;
		this.price = price;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		if(product==null){
			return " Shelf [capacity=" + capacity + ", product=none product stored" + ", price=" + price + "]";
		}
		else{
			return " Shelf [capacity=" + capacity + ", product=" + product.toString() + ", price=" + price + "]";
		}
	}
}
