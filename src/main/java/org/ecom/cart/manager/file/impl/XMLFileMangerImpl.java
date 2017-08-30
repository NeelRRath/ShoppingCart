package org.ecom.cart.manager.file.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.ecom.cart.bean.vo.Categories;
import org.ecom.cart.bean.vo.Category;
import org.ecom.cart.bean.vo.FlatDiscountSlabs;
import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ShoppingCart;
import org.ecom.cart.bean.vo.Slab;
import org.ecom.cart.exception.FileProcessingException;
import org.ecom.cart.manager.file.FileManager;

public class XMLFileMangerImpl implements FileManager {
	/**
	 * Get all the item and item Id mapping from the XML file.
	 * 
	 * @author Neel
	 * @param path String
	 * @return Map<String, Item>
	 * */
	@Override
	public Map<String, Item> readItemFromFile(String path) throws FileProcessingException {
		Map<String, Item> itemMap = new HashMap<>();
		try {
			JAXBContext context = JAXBContext.newInstance(ShoppingCart.class);
			Unmarshaller um = context.createUnmarshaller();
			File file = new File(this.getClass().getResource(path).getFile());
			ShoppingCart cartItems = (ShoppingCart) um.unmarshal(file);
			for (Item item : cartItems.getItem()) {
				itemMap.put(item.getItemID(), item);
			}
		} catch (Exception e) {
			throw new FileProcessingException(e.getMessage());
		}
		return itemMap;
	}
	/**
	 * Get all the category and Id mapping from the XML file.
	 * 
	 * @author Neel
	 * @param path String
	 * @return Map<String, Category>
	 * */
	@Override
	public Map<String, Category> readCategoryFromFile(String path) throws FileProcessingException {
		Map<String, Category> categoryMap = new HashMap<>();
		try {
			JAXBContext context = JAXBContext.newInstance(Categories.class);
			Unmarshaller um = context.createUnmarshaller();
			File file = new File(this.getClass().getResource(path).getFile());
			Categories cartCategories = (Categories) um.unmarshal(file);
			for (Category cat : cartCategories.getCategory()) {
				categoryMap.put(cat.getId(), cat);
			}
		} catch (Exception e) {
			throw new FileProcessingException(e.getMessage());
		}
		return categoryMap;
	}
	/**
	 * Get all the Slab in the  from the XML file.
	 * 
	 * @author Neel
	 * @param path String
	 * @return List<Slab>
	 * */
	@Override
	public List<Slab> readSalbFromFile(String path) throws FileProcessingException {
		List<Slab> slabList = new ArrayList<>();
		try {
			JAXBContext context = JAXBContext.newInstance(FlatDiscountSlabs.class);
			Unmarshaller um = context.createUnmarshaller();
			File file = new File(this.getClass().getResource(path).getFile());
			FlatDiscountSlabs discountSlabs = (FlatDiscountSlabs) um.unmarshal(file);
			slabList = discountSlabs.getSlab();
		} catch (Exception e) {
			throw new FileProcessingException(e.getMessage());
		}
		return slabList;
	}

	/**
	 * Get all the Item in the Shopping Cart from the XML file.
	 * 
	 * @author Neel
	 * @param path String
	 * @return ShoppingCart
	 * */
	@Override
	public ShoppingCart getShoppingCartFromFile(String path) throws FileProcessingException {
		ShoppingCart cartItems = null;
		try {
			JAXBContext context = JAXBContext.newInstance(ShoppingCart.class);
			Unmarshaller um = context.createUnmarshaller();
			File file = new File(this.getClass().getResource(path).getFile());
			cartItems = (ShoppingCart) um.unmarshal(file);
		} catch (Exception e) {
			throw new FileProcessingException(e.getMessage());
		}
		return cartItems;
	}

	/**
	 * Get all the Categories from the XML file.
	 * 
	 * @author Neel
	 * @param path String
	 * @return Categories
	 * */
	@Override
	public Categories getCategoryFromFile(String path) throws FileProcessingException {
		Categories cartCategories = null;
		try {
			JAXBContext context = JAXBContext.newInstance(Categories.class);
			Unmarshaller um = context.createUnmarshaller();
			File file = new File(this.getClass().getResource(path).getFile());
			cartCategories = (Categories) um.unmarshal(file);

		} catch (Exception e) {
			throw new FileProcessingException(e.getMessage());
		}
		return cartCategories;
	}

}
