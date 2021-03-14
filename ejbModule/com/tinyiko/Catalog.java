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
	
	private List<CatalogItem> catalogItems = new ArrayList<>();
	
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

}
