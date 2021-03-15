package com.tinyiko;

import java.util.List;

import javax.ejb.Local;


// EJB Interface

@Local
public interface CatalogLocal {
	
	public List<CatalogItem> getItems();
	
	public void addItem(CatalogItem catalogItem);
	
	public CatalogItem findItem(Long catalogItemId);
	
	public void deleteItem(CatalogItem catalogItem);
	
	public List<CatalogItem> searchByName(String name);

}
