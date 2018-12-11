package io.altar.jseproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Shelf extends BaseEntity{
	private static final long serialVersionUID=1L;

	private long capacity;
	@ManyToOne(cascade=CascadeType.ALL)
	private Product product;
	private double price;
	public Shelf(){}
	
	public Shelf(long capacity, Product product, double price) {
		super();
		
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public Shelf(long capacity, double price) {
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
			return "Shelf"+getId() + ", Shelf [capacity=" + capacity + ", product=none product stored" + ", price=" + price + "]";
		}
		else{
			return "Shelf"+getId() + ", Shelf [capacity=" + capacity + ", product=" + product.toString() + ", price=" + price + "]";
		}
	}
	
	
}
