package org.ecom.cart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.bean.vo.ShoppingCart;
import org.ecom.cart.manager.file.FileManager;
import org.ecom.cart.manager.receipt.ReceiptManager;
import org.ecom.cart.util.CartConstants;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Main class used for reading the xml passed  and calculating the
 * bill.
 * 
 * @author neel
 *
 */
public class MainShoppingCartTest {
	private FileManager filemanager;
	private ReceiptManager receiptManager; 
	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("cartContext.xml");
		assertNotNull(context);		
		filemanager = (FileManager)context.getBean("fileManager");
		assertNotNull(filemanager);
		receiptManager = (ReceiptManager)context.getBean("receiptManager");
		assertNotNull(receiptManager);
	}
	@Test
	public void mainTest() {
	     
		try {			
			
			ShoppingCart cart = filemanager.getShoppingCartFromFile(CartConstants.ITEM_FILE_PATH);
			assertNotNull(cart);
			assertEquals(4, cart.getItem().size());
			assertEquals(5, cart.getItem().size());
			assertEquals(3, cart.getItem().size());
			assertEquals(0, cart.getItem().size());
			Receipt receipt= receiptManager.calculate(cart.getItem());
			assertNotNull(receipt);
			assertEquals(4, receipt.getItems().size());
			assertEquals(1634.20d, receipt.getGrossTotal(), CartConstants.DELTA_PRECISION);
			assertEquals(32.68, receipt.getDiscount(), CartConstants.DELTA_PRECISION);
			assertEquals(1601.50d, receipt.getTotal(), CartConstants.DELTA_PRECISION);
			assertEquals(274d, receipt.getTotalDiscount(), CartConstants.DELTA_PRECISION);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
