package io.altar.jseproject.repositories;

import java.util.Collection;
//import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.jseproject.model.BaseEntity;

public abstract class EntityRepository<T extends BaseEntity>{

	
	//private Map<Long, T> map = new LinkedHashMap<Long, T>();
	//private long actualId = 0;


	//private long nextId(){
	//	return actualId ++;
	//}
	@PersistenceContext
	protected EntityManager entityManager;

	public T createEntities(T entity) {
		return entityManager.merge(entity);
	}
	/*public long createEntities(T ent) {
		long newId = nextId();
		ent.setId(newId);
		map.put(ent.getId(), ent);
		return newId;
	}*/
	//public Collection<T> consultEntities() {
		//return map.values();
	//}
	public T consultEntityById(long id){
		//return map.get(id);
		return entityManager.find(getTypeOfEntity(),id);
	}
	public void editEntity( T entity){
		//map.replace(id,ent);
		entityManager.merge(entity);

	}
	public void removeEntityById(long id){
		//map.remove(id);
		T entity = entityManager.find(getTypeOfEntity(),id);
		entityManager.remove(entity);
	}
	
	protected abstract Class<T> getTypeOfEntity();

}
