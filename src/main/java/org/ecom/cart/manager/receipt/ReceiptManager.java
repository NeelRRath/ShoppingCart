package org.ecom.cart.manager.receipt;

import java.util.List;

import org.ecom.cart.bean.vo.Item;
import org.ecom.cart.bean.vo.Receipt;
import org.ecom.cart.exception.DiscountProcessException;

/**
 * Interface for the discount manager for getting the discount
 * amounts of the current discount strategies.
 * 
 * @author neel
 *
 */
public interface ReceiptManager {

	/**
	 * Returns the receipt/bill calculated for the order items passed.
	 * 
	 * @param items
	 * @return
	 */
	Receipt calculate(List<Item> items) throws DiscountProcessException;

}
