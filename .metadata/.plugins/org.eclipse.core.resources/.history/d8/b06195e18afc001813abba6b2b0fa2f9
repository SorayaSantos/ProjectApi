package io.altar.jseproject.business;

import org.modelmapper.ModelMapper;

import io.altar.jseproject.dto.EntityDTO;
import io.altar.jseproject.dto.ProductDTO;
import io.altar.jseproject.dto.ShelfDTO;
import io.altar.jseproject.model.Entity;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;

public class ModelMapperApplication {

	public EntityDTO modelMapperApp(Entity entity) {
		
		ModelMapper entityModelMapper = new ModelMapper();
		EntityDTO entityDTO = new EntityDTO();
		
		entityModelMapper.map(entity,entityDTO);
		
		return entityDTO;
	}
}
