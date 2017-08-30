package org.ecom.cart.test.helper;

import org.ecom.cart.bean.vo.Item;



/**
 * Helper class for running the tests.
 * 
 * @author Neel
 *
 */
public final class ItemHelper {
	
	private ItemHelper(){
	}
	
	public static Item getPasta() {	
		return new Item("Pasta 1kg","1", 4.29d,1l, "001");
	}
	
	public static Item getCoffee() {
		return new Item("Coffee 500g","2", 3.21d, 1l,"001");
	}
	
	public static Item getBook1() {
		return new Item("Book 1","3", 10.12d,  1l,"002");
	}
	
	public static Item getBook2() {
		return new Item("Book 2","4", 15.05d,  1l,"002");
	}
	
	public static Item getCake() {
		return new Item("Cake","5", 2.35d,   1l,"001");
	}
	
	public static Item getChocolate() {
		return new Item("Chocolate","6", 2.1d,  10l,"001");
	}
	
	public static Item getApple() {
		return new Item("Apple", "7",0.5d, 5l,"001");
	}
	
	public static Item getWine() {
		return new Item("Wine", "8",10.5d, 1l,"001");
	}
	
}
