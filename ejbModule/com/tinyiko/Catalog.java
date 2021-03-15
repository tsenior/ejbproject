package com.tinyiko;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Catalog implements CatalogLocal {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	//private List<CatalogItem> catalogItems = new ArrayList<>();
	
	public Catalog() {
		super();
	}

	public List<CatalogItem> getItems() {
		return this.entityManager.createQuery("select c from CatalogItem c", CatalogItem.class).getResultList();
	}

	@Override
	public void addItem(CatalogItem catalogItem) {
		this.entityManager.persist(catalogItem);
		
	}

	@Override
	public CatalogItem findItem(Long catalogItemId) {
		return this.entityManager.find(CatalogItem.class, catalogItemId);
	}

	@Override
	public void deleteItem(CatalogItem catalogItem) {
		//1. first check to see if it an item is within the persistence context
		//2. if it is we just pass the item to delete
		//3. if it is not we tell entity manager to perform merge which will add the item
		this.entityManager.remove(this.entityManager.contains(catalogItem) ? catalogItem:this.entityManager.merge(catalogItem));
		
	}

	@Override
	public List<CatalogItem> searchByName(String name) {
		
		return this.entityManager.createQuery("select c from CatalogItem c " +
				" where c.name like :name", CatalogItem.class).
				setParameter("name", "%" + name + "%").getResultList();
	}

}
