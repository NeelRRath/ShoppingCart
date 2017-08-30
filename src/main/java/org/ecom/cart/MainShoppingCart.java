package org.ecom.cart;

import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.bean.vo.ReceiptItem;
import org.ecom.cart.bean.vo.ShoppingCart;
import org.ecom.cart.manager.file.FileManager;
import org.ecom.cart.manager.receipt.ReceiptManager;
import org.ecom.cart.util.CartConstants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Main class used for reading the xml passed  and calculating the
 * bill.
 * 
 * @author neel
 *
 */
public class MainShoppingCart {
	

	public static void main(String[] args) {
	     
		try {
			
			ApplicationContext context = new ClassPathXmlApplicationContext("cartContext.xml");
			FileManager fm =  (FileManager) context.getBean("fileManager");
			ShoppingCart cart = fm.getShoppingCartFromFile(CartConstants.ITEM_FILE_PATH);
			ReceiptManager rm = (ReceiptManager)context.getBean("receiptManager");
			Receipt receipt= rm.calculate(cart.getItem());
			System.out.println( "         Item Name           |  Item Unit Price  |  Quantity  |  Total Unit Price  |  Discount  |  Gross Unit Price");
			System.out.println( "------------------------------------------------------------------------------------------------------------------------");
			
			for(ReceiptItem item  :receipt.getItems() ){
				System.out.println(item.print());
			}
			System.out.println( "------------------------------------------------------------------------------------------------------------------------");
			
			System.out.println(receipt.print());
			System.out.println( "------------------------------------------------------------------------------------------------------------------------");
			System.out.println(receipt.print1());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
