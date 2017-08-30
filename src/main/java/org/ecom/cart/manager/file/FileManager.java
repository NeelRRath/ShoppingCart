package org.ecom.cart.manager.file;

import java.util.List;
import java.util.Map;

import org.ecom.cart.bean.vo.Categories;
import org.ecom.cart.bean.vo.Category;
import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ShoppingCart;
import org.ecom.cart.bean.vo.Slab;
import org.ecom.cart.exception.FileProcessingException;

public interface FileManager {
	Map<String, Item> readItemFromFile(String path)throws FileProcessingException;

	Map<String, Category> readCategoryFromFile(String path) throws FileProcessingException;

	List<Slab> readSalbFromFile(String path)throws FileProcessingException ;
	
	ShoppingCart getShoppingCartFromFile(String path)throws FileProcessingException;

	Categories getCategoryFromFile(String path) throws FileProcessingException;

}
