package com.tinyiko.ejbean;

import java.util.List;

import javax.ejb.Local;

import com.tinyiko.entities.CatalogItem;


// EJB Interface

@Local
public interface CatalogLocal {
	
	public List<CatalogItem> getItems();
	
	public void addItem(CatalogItem catalogItem);
	
	public CatalogItem findItem(Long catalogItemId);
	
	public void deleteItem(CatalogItem catalogItem);
	
	public List<CatalogItem> searchByName(String name);
	
	public void saveItem(CatalogItem catalogItem);

}
