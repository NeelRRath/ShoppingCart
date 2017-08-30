package org.ecom.cart.test.bean;

import static org.junit.Assert.assertEquals;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ReceiptItem;
import org.ecom.cart.util.CartConstants;
import org.junit.Test;

/**
 * Unit test for {@link ReceiptItem}.
 * @author Neel
 */
public class ReceiptItemTest {

	@Test
	public void shouldReturnFinalPriceTotal() {
		ReceiptItem item = new ReceiptItem(new Item("Test", "1", 3d, 10l, "002"), 3d, 10d);
		assertEquals(27, item.getFinalPrice(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnFinalPriceTotalZeroIfQuantityIsZero() {
		ReceiptItem item = new ReceiptItem(new Item("Test", "1", 3d, 0l, "002"), 3d, 10d);
		assertEquals(0, item.getFinalPrice(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnFinalPriceTotalZeroIfPriceIsZero() {
		ReceiptItem item = new ReceiptItem(new Item("Test", "1", 0d, 10l, "002"), 3d, 10d);
		assertEquals(0, item.getFinalPrice(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldReturnFinalPriceTotalEqualToGrossTotal() {
		ReceiptItem item = new ReceiptItem(new Item("Test", "1", 3d, 10l, "002"), 0d, 0d);
		assertEquals(30d, item.getFinalPrice(), CartConstants.DELTA_PRECISION);
	}
	
}