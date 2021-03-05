package com.tinyiko;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Catalog
 */
@Stateless
@LocalBean
public class Catalog implements CatalogLocal {

    public Catalog() {
    }

	@Override
	public List<CatalogItem> getItems() {
		return null;
	}

	@Override
	public void addItem(CatalogItem catalogItem) {
		
	}

}
