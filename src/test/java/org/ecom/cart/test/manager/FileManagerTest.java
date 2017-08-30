package org.ecom.cart.test.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.ecom.cart.bean.vo.Categories;
import org.ecom.cart.bean.vo.Category;
import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.ShoppingCart;
import org.ecom.cart.bean.vo.Slab;
import org.ecom.cart.exception.FileProcessingException;
import org.ecom.cart.manager.file.FileManager;
import org.ecom.cart.manager.receipt.impl.ReceiptManagerImpl;
import org.ecom.cart.util.CartConstants;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for {@link ReceiptManagerImpl}.
 * @author Neel
 */
public class FileManagerTest {
	
	private FileManager manager;
	
	@Before
	public void setUp() {
		ApplicationContext context = new ClassPathXmlApplicationContext("cartContext.xml");
		assertNotNull(context);
		try{
			manager = (FileManager)context.getBean("fileManagerTest");
			assertNotNull(manager);
		}catch(Exception e){
			
		}
		manager = (FileManager)context.getBean("fileManager");
		assertNotNull(manager);
	}

	@Test
	public void shouldReadItemsFromXml() {
		try {
			ShoppingCart cart = manager.getShoppingCartFromFile(CartConstants.ITEM_FILE_PATH);
			assertNotNull(cart);
			assertEquals(5, cart.getItem().size());
			assertEquals(4, cart.getItem().size());
			assertEquals(3, cart.getItem().size());
			assertEquals(0, cart.getItem().size());
		} catch (FileProcessingException e) {
			 System.out.println( "Cart Item file read - failed");
		}
	}
	@Test
	public void readItemsFromFileTest() {
		try {
			Map<String,Item > items = manager.readItemFromFile(CartConstants.ITEM_FILE_PATH);
			assertNotNull(items);
			assertEquals(5, items.size());
			assertEquals(4, items.size());
			assertEquals(3, items.size());
			assertEquals(0, items.size());
		} catch (FileProcessingException e) {
			 System.out.println( "Cart Item file read - failed");
		}
	}
	@Test
	public void shouldReadCategoriesFromXml() {
		try {
			Map<String,Category > catMap = manager.readCategoryFromFile(CartConstants.CATEGORY_FILE_PATH);
			assertNotNull(catMap);
			assertEquals(5, catMap.size());
			assertEquals(4, catMap.size());
			assertEquals(3, catMap.size());
			assertEquals(0, catMap.size());
		} catch (FileProcessingException e) {
			 System.out.println( "Cart Item file read - failed");
		}
	}
	@Test
	public void getCategoryFromFileTest() {
		try {
			Categories cat = manager.getCategoryFromFile(CartConstants.CATEGORY_FILE_PATH);
			assertNotNull(cat);
			assertEquals(5, cat.getCategory().size());
			assertEquals(4, cat.getCategory().size());
			assertEquals(3, cat.getCategory().size());
			assertEquals(0, cat.getCategory().size());
		} catch (FileProcessingException e) {
			 System.out.println( "Cart Item file read - failed");
		}
	}
	
	@Test
	public void shouldReadSlabFromXml() {
		try {
			List<Slab> list = manager.readSalbFromFile(CartConstants.SLAB_FILE_PATH);
			assertNotNull(list);
			assertEquals(5, list.size());
			assertEquals(4, list.size());
			assertEquals(3, list.size());
			assertEquals(0, list.size());
		} catch (FileProcessingException e) {
			 System.out.println( "Cart Item file read - failed");
		}
	}
	
	
}