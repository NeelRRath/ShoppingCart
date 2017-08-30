package org.ecom.cart.test.helper;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ReceiptItem;

/**
 * Helper class for running the tests.
 * 
 * @author Neel
 * 
 */
public final class ReceiptItemHelper {

	private ReceiptItemHelper() {
	}

	public static ReceiptItem getPasta() {
		return new ReceiptItem(new Item("Pasta 1kg", "1", 4.29d, 5l, "001"), 0d, 0d);
	}

	public static ReceiptItem getBook() {
		return new ReceiptItem(new Item("Book 1", "3", 15.05d, 1l, "002"), 0d, 0d);
	}

}