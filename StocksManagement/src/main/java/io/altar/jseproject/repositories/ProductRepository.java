package io.altar.jseproject.repositories;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class ProductRepository extends EntityRepository<Product> {
	
	private static final ProductRepository INSTANCE = new ProductRepository();
	
	public static ProductRepository getInstance(){
		return INSTANCE;
	}
	private ProductRepository(){
		
	}
	@Override
	protected Class<Product> getTypeOfEntity(){
		return Product.class;
	};
	@Override
	protected String getNameOfQuery(){
		return Product.nameOfQuery;
	};
}
