package org.ecom.cart.test.bean;

import static org.junit.Assert.assertEquals;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.util.CartConstants;
import org.junit.Test;

/**
 * Unit test for {@link Item}.
 * 
 */
public class ItemTest {

	@Test
	public void shouldReturnGrossTotal() {
		Item item = new Item("Test", "1", 3d, 10l, "002");
		assertEquals(30d, item.getGrossTotal(), CartConstants.DELTA_PRECISION);
	}

	@Test
	public void shouldBeZeroIfQuantityIsZero() {
		Item item = new Item("Test", "1", 3d, 0l, "002");
		assertEquals(0, item.getGrossTotal(), CartConstants.DELTA_PRECISION);
	}

	@Test
	public void shouldBeZeroIfPriceIsZero() {
		Item item = new Item("Test", "1", 0d, 10l, "002");
		assertEquals(0, item.getGrossTotal(), CartConstants.DELTA_PRECISION);
	}

}