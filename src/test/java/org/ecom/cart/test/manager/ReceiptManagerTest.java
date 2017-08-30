package org.ecom.cart.test.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.exception.DiscountProcessException;
import org.ecom.cart.manager.receipt.ReceiptManager;
import org.ecom.cart.manager.receipt.impl.ReceiptManagerImpl;
import org.ecom.cart.test.helper.ItemHelper;
import org.ecom.cart.util.CartConstants;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for {@link ReceiptManagerImpl}.
 * @author Neel
 */
public class ReceiptManagerTest {
	
	private ReceiptManager manager;
	
	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("cartContext.xml");
		assertNotNull(context);
		
		manager = (ReceiptManager)context.getBean("receiptManagerTest");
		assertNotNull(manager);
		manager = (ReceiptManager)context.getBean("receiptManager");
		assertNotNull(manager);
	}

	@Test
	public void shouldCalculateReceiptForInput1() {
		List<Item> items = new ArrayList<Item>();
		items.add(ItemHelper.getPasta());
		items.add(ItemHelper.getBook1());
		
		Receipt receipt = null;
		try {
			receipt = manager.calculate(items);
		} catch (DiscountProcessException e) {			
			e.printStackTrace();
		}		
		assertNotNull(receipt);
		assertEquals(12.88d, receipt.getGrossTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(0d, receipt.getDiscount(), CartConstants.DELTA_PRECISION);
		assertEquals(12.90d, receipt.getTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(1.53d, receipt.getTotalDiscount(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldCalculateReceiptForInput2() {
		List<Item> items = new ArrayList<Item>();
		items.add(ItemHelper.getCoffee());
		items.add(ItemHelper.getPasta());
		items.add(ItemHelper.getCake());
		
		Receipt receipt = null;
		try {
			receipt = manager.calculate(items);
		} catch (DiscountProcessException e) {			
			e.printStackTrace();
		}	
		
		assertNotNull(receipt);
		assertEquals(9.29d, receipt.getGrossTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(0d, receipt.getDiscount(), CartConstants.DELTA_PRECISION);
		assertEquals(9.3d, receipt.getTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(0.56d, receipt.getTotalDiscount(), CartConstants.DELTA_PRECISION);
	}
	
	@Test
	public void shouldCalculateReceiptForInput3() {
		List<Item> items = new ArrayList<Item>();
		items.add(ItemHelper.getChocolate());
		items.add(ItemHelper.getWine());
		items.add(ItemHelper.getBook2());
		items.add(ItemHelper.getApple());
		
		Receipt receipt = null;
		try {
			receipt = manager.calculate(items);
		} catch (DiscountProcessException e) {			
			e.printStackTrace();
		}	
		
		assertNotNull(receipt);
		assertEquals(47.24d, receipt.getGrossTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(2.36d, receipt.getDiscount(), CartConstants.DELTA_PRECISION);
		assertEquals(44.9d, receipt.getTotal(), CartConstants.DELTA_PRECISION);
		assertEquals(4.17d, receipt.getTotalDiscount(), CartConstants.DELTA_PRECISION);
	}
	
	
}