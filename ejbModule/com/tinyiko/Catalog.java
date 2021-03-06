package com.tinyiko;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Catalog implements CatalogLocal {
	
	private List<CatalogItem> catalogItems = new ArrayList<>();
	
	public Catalog() {
		super();
	}

	public List<CatalogItem> getItems() {
		return this.catalogItems;
	}

	@Override
	public void addItem(CatalogItem catalogItem) {
		this.catalogItems.add(catalogItem);
		
	}

}
